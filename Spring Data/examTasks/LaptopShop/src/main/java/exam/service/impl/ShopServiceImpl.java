package exam.service.impl;

import exam.model.dto.ShopSeedRootDto;
import exam.model.entity.Shop;
import exam.model.entity.Town;
import exam.repository.ShopRepository;
import exam.repository.TownRepository;
import exam.service.ShopService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ShopServiceImpl implements ShopService {

    private static final String SHOP_DATA_XML = "src/main/resources/files/xml/shops.xml";
    private final ShopRepository shopRepository;
    private final TownRepository townRepository;
    private final softuni.exam.util.ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    private final softuni.exam.util.XmlParser xmlParser;

    public ShopServiceImpl(ShopRepository shopRepository, TownRepository townRepository, ValidationUtil validationUtil, ModelMapper modelMapper, XmlParser xmlParser) {
        this.shopRepository = shopRepository;
        this.townRepository = townRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }


    @Override
    public boolean areImported() {
        return shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(Path.of(SHOP_DATA_XML));
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {
        if (!areImported()) {
            StringBuilder strBuilder = new StringBuilder();

            xmlParser
                    .fromFile(SHOP_DATA_XML, ShopSeedRootDto.class)
                    .getShopSeedDtoSet()
                    .stream()
                    .filter(shopSeedDto -> {
                        boolean isValid = validationUtil.isValid(shopSeedDto)
                                && isNonExistingEntity(shopSeedDto.getName());
                        strBuilder.append(generateSeedResponse(
                                shopSeedDto.getName(), shopSeedDto.getIncome(), isValid));
                        return isValid;
                    })
                    .map(shopSeedDto -> {
                        Shop shop = modelMapper.map(shopSeedDto, Shop.class);
                        Town town = townRepository.getTownByName(shopSeedDto.getTown().getName());
                        shop.setTown(town);
                        return shop;
                    })
                    .forEach(shopRepository::save);
            return strBuilder.toString().trim();
        }
        return null;
    }

    private boolean isNonExistingEntity(String shopName) {
        return !shopRepository.existsByName(shopName);
    }

    private String generateSeedResponse(String shopName, BigDecimal income, boolean isValid) {
        return isValid
                    ? String.format("Successfully imported Shop %s - %.2f%s",
                shopName, income, System.lineSeparator())
                : String.format("Invalid shop%s", System.lineSeparator());
    }
}
