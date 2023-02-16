package exam.service.impl;

import exam.model.dto.TownSeedRootDto;
import exam.model.entity.Town;
import exam.repository.TownRepository;
import exam.service.TownService;
import exam.util.ValidationUtil;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TownServiceImpl implements TownService {

    private static final String TOWN_DATA_XML = "src/main/resources/files/xml/towns.xml";
    private final TownRepository townRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    public TownServiceImpl(TownRepository townRepository, ValidationUtil validationUtil,
                           ModelMapper modelMapper, XmlParser xmlParser) {
        this.townRepository = townRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWN_DATA_XML));
    }

    @Override
    public String importTowns() throws JAXBException, FileNotFoundException {
        if (!areImported()) {
            StringBuilder strBuilder = new StringBuilder();

            xmlParser
                    .fromFile(TOWN_DATA_XML, TownSeedRootDto.class)
                    .getTownSeedDtoSet()
                    .stream()
                    .filter(townSeedDto -> {
                        boolean isValid = validationUtil.isValid(townSeedDto)
                                && isNonExistingEntity(townSeedDto.getName());
                        strBuilder.append(generateSeedResponse(
                                townSeedDto.getName(), isValid));
                        return isValid;
                    })
                    .map(townSeedDto -> modelMapper.map(townSeedDto, Town.class))
                    .forEach(townRepository::save);
            return strBuilder.toString().trim();
        }
        return null;
    }

    private boolean isNonExistingEntity(String townName) {
        return !townRepository.existsByName(townName);
    }

    private String generateSeedResponse(String townName, boolean isValid) {
        return isValid
                ? String.format("Successfully imported Town %s%s",
                townName, System.lineSeparator())
                : String.format("Invalid town%s", System.lineSeparator());
    }

}
