package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TownSeedDto;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class TownServiceImpl implements TownService {
    private static final String TOWN_JSON_FILE = "src/main/resources/files/json/towns.json";
    private final TownRepository townRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public TownServiceImpl(TownRepository townRepository, ValidationUtil validationUtil, ModelMapper modelMapper, Gson gson) {
        this.townRepository = townRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWN_JSON_FILE));
    }

    @Override
    public String importTowns() throws IOException {
        if (!areImported()) {
            StringBuilder output = new StringBuilder();
            Arrays.stream(gson
                            .fromJson(readTownsFileContent(), TownSeedDto[].class))
                    .filter(townSeedDto -> {
                        boolean isValid = validationUtil.isValid(townSeedDto)
                                && isNonExistingEntity(townSeedDto.getTownName());
                        output.append(generateSeedResponse(townSeedDto.getTownName(),
                                townSeedDto.getPopulation(), isValid));
                        return isValid;
                    })
                    .map(townSeedDto -> modelMapper.map(townSeedDto, Town.class))
                    .forEach(townRepository::save);

            return output.toString().trim();
        }
        return null;
    }

    @Override
    public Town findByName(String town) {
        return townRepository.findByTownName(town);
    }

    private boolean isNonExistingEntity(String townName) {
        return !townRepository.existsByTownName(townName);
    }

    private String generateSeedResponse(String name, Integer population, boolean isValid) {
        return isValid
                ? String.format("Successfully imported town %s - %d%s",
                name, population, System.lineSeparator())
                : String.format("Invalid town%s", System.lineSeparator());
    }
}
