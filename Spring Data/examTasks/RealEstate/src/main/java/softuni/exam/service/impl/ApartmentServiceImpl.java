package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ApartmentSeedRootDto;
import softuni.exam.models.dto.OfferApartmentSeedDto;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.constraints.ApartmentType;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    private static final String APARTMENTS_XML_FILE = "src/main/resources/files/xml/apartments.xml";
    private final ApartmentRepository apartmentRepository;
    private final TownService townService;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    public ApartmentServiceImpl(ApartmentRepository apartmentRepository, TownService townService, ValidationUtil validationUtil,
                                ModelMapper modelMapper, XmlParser xmlParser) {
        this.apartmentRepository = apartmentRepository;
        this.townService = townService;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(Path.of(APARTMENTS_XML_FILE));
    }

    @Override
    public String importApartments() throws IOException, JAXBException {
        if (!areImported()) {
            StringBuilder strBuilder = new StringBuilder();

            xmlParser
                    .fromFile(APARTMENTS_XML_FILE, ApartmentSeedRootDto.class)
                    .getApartmentSeedDtoList()
                    .stream()
                    .filter(apartmentSeedDto -> {
                        boolean isValid = validationUtil.isValid(apartmentSeedDto)
                                && townService.findByName(apartmentSeedDto.getTown()) != null
                                && validationUtil.enumContains(ApartmentType.class, apartmentSeedDto.getApartmentType());
                        strBuilder.append(generateSeedResponse(
                                apartmentSeedDto.getApartmentType(), apartmentSeedDto.getArea(), isValid));
                        return isValid;
                    })
                    .map(apartmentSeedDto -> {
                        Apartment apartment = modelMapper.map(apartmentSeedDto, Apartment.class);
                        apartment.setTown(townService.findByName(apartmentSeedDto.getTown()));
                        return apartment;
                    })
                    .forEach(apartmentRepository::save);
            return strBuilder.toString().trim();
        }

        return null;
    }

    @Override
    public Apartment getById(Long apartmentId) {
        return apartmentRepository.getApartmentById(apartmentId);
    }

    private String generateSeedResponse(String apartmentType, Double area, boolean isValid) {
        return isValid
                ? String.format("Successfully imported apartment %s - %.2f%s",
                apartmentType, area, System.lineSeparator())
                : String.format("Invalid apartment%s", System.lineSeparator());
    }
}
