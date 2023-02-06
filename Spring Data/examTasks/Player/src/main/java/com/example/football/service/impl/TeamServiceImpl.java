package com.example.football.service.impl;

import com.example.football.models.dto.TeamSeedDto;
import com.example.football.models.entity.Team;
import com.example.football.repository.TeamRepository;
import com.example.football.service.TeamService;
import com.example.football.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

//ToDo - Implement all methods
@Service
public class TeamServiceImpl implements TeamService {

    private static final String RESOURCES_JSON_TEAMS_PATH = "src/main/resources/files/json/teams.json";
    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public TeamServiceImpl(TeamRepository teamRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.teamRepository = teamRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(Path.of(RESOURCES_JSON_TEAMS_PATH));
    }

    @Override
    public String importTeams() throws IOException {
        if (!areImported()) {
            StringBuilder output = new StringBuilder();

            Arrays.stream(gson
                            .fromJson(readTeamsFileContent(), TeamSeedDto[].class))
                    .filter(teamSeedDto -> {
                        boolean isValid = validationUtil.isValid(teamSeedDto);
                        output.append(getResponse(teamSeedDto.getName(), teamSeedDto.getFanBase(),
                                isValid));
                        return isValid;
                    })
                    .map(teamSeedDto -> modelMapper.map(teamSeedDto, Team.class))
                    .forEach(teamRepository::save);

            return output.toString().trim();
        }
        return null;
    }

    private String getResponse(String name, Integer fanBase, boolean isValid) {
        return isValid
                ? String.format("Successfully imported Team %s - %s%s",
                name, fanBase, System.lineSeparator())
                : String.format("Invalid Team%s", System.lineSeparator());
    }

    @Override
    public Team findByName(String name) {
        return teamRepository.findTeamByName(name);
    }
}
