package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.LaptopSeedDto;
import exam.model.entity.*;
import exam.repository.LaptopRepository;
import exam.repository.ShopRepository;
import exam.service.LaptopService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class LaptopServiceImpl implements LaptopService {
    private static final String     LAPTOP_DATA_JSON = "src/main/resources/files/json/laptops.json";
    private final LaptopRepository laptopRepository;
    private final ShopRepository shopRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public LaptopServiceImpl(LaptopRepository laptopRepository, ShopRepository shopRepository, ValidationUtil validationUtil, ModelMapper modelMapper, Gson gson) {
        this.laptopRepository = laptopRepository;
        this.shopRepository = shopRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files.readString(Path.of(LAPTOP_DATA_JSON));
    }

    @Override
    public String importLaptops() throws IOException {
        if (!areImported()) {
            StringBuilder output = new StringBuilder();
            Arrays.stream(gson
                            .fromJson(readLaptopsFileContent(), LaptopSeedDto[].class))
                    .filter(laptopSeedDto -> {
                        boolean isValid = validationUtil.isValid(laptopSeedDto)
                                && validationUtil.enumContains(WarrantyType.class,
                                laptopSeedDto.getWarrantyType());
                        output.append(generateSeedResponse(laptopSeedDto.getMacAddress(),
                                laptopSeedDto.getCpuSpeed(), laptopSeedDto.getRam(),
                                laptopSeedDto.getStorage(), isValid));
                        return isValid;
                    })
                    .map(laptopSeedDto -> {
                        Laptop laptop = modelMapper.map(laptopSeedDto, Laptop.class);
                        Shop shop = shopRepository.getShopByName(laptopSeedDto.getShop().getName());
                        laptop.setShop(shop);
                        return laptop;
                    })
                    .forEach(laptopRepository::save);

            return output.toString().trim();
        }
        return null;
    }

    @Override
    public String exportBestLaptops() {

        StringBuilder sb = new StringBuilder();
        laptopRepository
                .getBestByCpuAndRamAndStorageAndMacAddress()
                .forEach(laptop -> {
                    sb.append(String.format("Laptop - %s\n", laptop.getMacAddress()))
                            .append(String.format("*Cpu speed - %.2f\n", laptop.getCpuSpeed()))
                            .append(String.format("**Ram - %d\n", laptop.getRam()))
                            .append(String.format("***Storage - %d\n", laptop.getStorage()))
                            .append(String.format("****Price - %.2f\n", laptop.getPrice()))
                            .append(String.format("#Shop name - %s\n", laptop.getShop().getName()))
                            .append(String.format("##Town - %s", laptop.getShop().getTown().getName()))
                            .append(System.lineSeparator()).append(System.lineSeparator());
                });
        return sb.toString();
    }

    private String generateSeedResponse(String macAddress, Double cpu, Integer ram,
                                        Integer storage, boolean isValid) {
        return isValid
                ? String.format("Successfully imported Laptop %s - %.2f - %d - %d%s",
                macAddress, cpu, ram, storage, System.lineSeparator())
                : String.format("Invalid Laptop%s", System.lineSeparator());
    }
}
