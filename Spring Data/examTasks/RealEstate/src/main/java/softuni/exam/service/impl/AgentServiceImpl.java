package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AgentSeedDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.repository.AgentRepository;
import softuni.exam.service.AgentService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class AgentServiceImpl implements AgentService {
    private static final String AGENT_JSON_FILE = "src/main/resources/files/json/agents.json";
    private final AgentRepository agentRepository;
    private TownService townService;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public AgentServiceImpl(AgentRepository agentRepository, TownService townService, ValidationUtil validationUtil,
                            ModelMapper modelMapper, Gson gson) {
        this.agentRepository = agentRepository;
        this.townService = townService;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(Path.of(AGENT_JSON_FILE));
    }

    @Override
    public String importAgents() throws IOException {
        if (!areImported()) {
            StringBuilder output = new StringBuilder();
            Arrays.stream(gson
                            .fromJson(readAgentsFromFile(), AgentSeedDto[].class))
                    .filter(agentSeedDto -> {
                        boolean isValid = validationUtil.isValid(agentSeedDto)
                                && isNonExistingEntity(agentSeedDto.getFirstName())
                                && townService.findByName(agentSeedDto.getTown()) != null;
                        output.append(generateSeedResponse(agentSeedDto.getFirstName(),
                                agentSeedDto.getLastName(), isValid));
                        return isValid;
                    })
                    .map(agentSeedDto -> {
                        Agent agent = modelMapper.map(agentSeedDto, Agent.class);
                        agent.setTown(townService.findByName(agentSeedDto.getTown()));
                        return agent;
                    })
                    .forEach(agentRepository::save);

            return output.toString().trim();
        }
        return null;
    }

    @Override
    public Agent findByFirstName(String firstName) {
        return agentRepository.findByFirstName(firstName);
    }

    private boolean isNonExistingEntity(String firstName) {
        return !agentRepository.existsByFirstName(firstName);
    }

    private String generateSeedResponse(String firstName, String lastName, boolean isValid) {
        return isValid
                ? String.format("Successfully imported agent - %s %s%s",
                firstName, lastName, System.lineSeparator())
                : String.format("Invalid agent%s", System.lineSeparator());
    }
}
