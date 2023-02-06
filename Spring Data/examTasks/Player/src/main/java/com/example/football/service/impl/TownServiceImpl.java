package com.example.football.service.impl;

import com.example.football.models.dto.TownSeedDto;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class TownServiceImpl implements TownService {

    private static final String RESOURCES_JSON_TOWNS_PATH = "src/main/resources/files/json/towns.json";
    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public TownServiceImpl(TownRepository townRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(RESOURCES_JSON_TOWNS_PATH));
    }

    @Override
    public String importTowns() throws IOException {
        if (!areImported()) {
            StringBuilder output = new StringBuilder();

            Arrays.stream(gson
                    .fromJson(readTownsFileContent(), TownSeedDto[].class))
                    .filter(townSeedDto -> {
                        boolean isValid = validationUtil.isValid(townSeedDto);
                        output.append(getResponse(townSeedDto.getName(), townSeedDto.getPopulation(), 
                                isValid));
                        return isValid;
                    })
                    .map(townSeedDto -> modelMapper.map(townSeedDto, Town.class))
                    .forEach(townRepository::save);

            return output.toString().trim();
        }
        return null;
    }

    private String getResponse(String name, Integer population, boolean isValid) {
        return isValid
                ? String.format("Successfully imported Town %s - %s%s",
                name, population, System.lineSeparator())
                : String.format("Invalid Town%s", System.lineSeparator());
    }

    @Override
    public Town findByName(String name) {
        return townRepository.findTownByName(name);
    }
}
