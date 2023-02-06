package com.example.football.service.impl;

import com.example.football.models.dto.StatSeedDto;
import com.example.football.models.dto.StatSeedRootDto;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class StatServiceImpl implements StatService {

    private static final String RESOURCES_XML_STATS_PATH = "src/main/resources/files/xml/stats.xml";
    private final StatRepository statRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    public StatServiceImpl(StatRepository statRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.statRepository = statRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(Path.of(RESOURCES_XML_STATS_PATH));
    }

    @Override
    public String importStats() throws JAXBException, FileNotFoundException {
        if (!areImported()) {
            StringBuilder output = new StringBuilder();
            xmlParser
                    .fromFile(RESOURCES_XML_STATS_PATH, StatSeedRootDto.class)
                    .getStatSeedDtoList()
                    .stream()
                    .filter(statSeedDto -> {
                        boolean isValid = validationUtil.isValid(statSeedDto);
                        output.append(getResponse(statSeedDto.getPassing(),statSeedDto.getShooting(),
                                statSeedDto.getEndurance(), isValid));
                        return isValid;
                    })
                    .map(statSeedDto -> modelMapper.map(statSeedDto, Stat.class))
                    .forEach(statRepository::save);
            return output.toString().trim();
        }
        return null;
    }

    private String getResponse(Double passing, Double shooting, Double endurance, boolean isValid) {
        return isValid
                ? String.format("Successfully imported Stat %s - %s - %s%s",
                passing, shooting, endurance, System.lineSeparator())
                : String.format("Invalid Stat%s", System.lineSeparator());
    }

    @Override
    public Stat findById(Long id) {
        return statRepository.findById(id).orElse(null);
    }
}
