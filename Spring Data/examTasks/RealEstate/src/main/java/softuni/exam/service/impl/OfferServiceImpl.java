package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ApartmentSeedRootDto;
import softuni.exam.models.dto.OfferSeedRootDto;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Offer;
import softuni.exam.models.entity.constraints.ApartmentType;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.AgentService;
import softuni.exam.service.ApartmentService;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class OfferServiceImpl implements OfferService {
    private static final String OFFERS_XML_FILE = "src/main/resources/files/xml/offers.xml";
    private final OfferRepository offerRepository;
    private final ApartmentService apartmentService;
    private final AgentService agentService;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    public OfferServiceImpl(OfferRepository offerRepository, ApartmentService apartmentService,
                            AgentService agentService, ValidationUtil validationUtil,
                            ModelMapper modelMapper, XmlParser xmlParser) {
        this.offerRepository = offerRepository;
        this.apartmentService = apartmentService;
        this.agentService = agentService;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFERS_XML_FILE));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        if (!areImported()) {
            StringBuilder strBuilder = new StringBuilder();

            xmlParser
                    .fromFile(OFFERS_XML_FILE, OfferSeedRootDto.class)
                    .getOfferSeedDtoList()
                    .stream()
                    .filter(offerSeedDto -> {
                        boolean isValid = validationUtil.isValid(offerSeedDto)
                                && agentService.findByFirstName(offerSeedDto.getAgent().getName()) != null
                                && apartmentService.getById(offerSeedDto.getApartment().getId()) != null;
                        strBuilder.append(generateSeedResponse(
                                offerSeedDto.getPrice(), isValid));
                        return isValid;
                    })
                    .map(offerSeedDto -> {
                        Offer offer = modelMapper.map(offerSeedDto, Offer.class);
                        offer.setAgent(agentService.findByFirstName(offerSeedDto.getAgent().getName()));
                        offer.setApartment(apartmentService.getById(offerSeedDto.getApartment().getId()));
                        return offer;
                    })
                    .forEach(offerRepository::save);
            return strBuilder.toString().trim();
        }
        return null;
    }

    @Override
    public String exportOffers() {
        StringBuilder sb = new StringBuilder();
        offerRepository
                .findThreeRoomApartmentsOrderByApartmentAreaDescPriceAsc()
                .forEach(apartment -> {
                    sb.append(String.format("Agent %s %s with offer №%d:\n",
                                    apartment.getAgent().getFirstName(), apartment.getAgent().getLastName(),
                                    apartment.getId()))
                            .append(String.format("\t-Apartment area: %.2f\n",
                                    apartment.getApartment().getArea()))
                            .append(String.format("\t--Town: %s\n",
                                    apartment.getApartment().getTown().getTownName()))
                            .append(String.format("\t---Price: %.2f$\n",
                                    apartment.getPrice()))
                            .append(System.lineSeparator());
                });
        return sb.toString();
    }

    private String generateSeedResponse(BigDecimal offerPrice, boolean isValid) {
        return isValid
                ? String.format("Successfully imported offer %.2f%s",
                offerPrice, System.lineSeparator())
                : String.format("Invalid offer%s", System.lineSeparator());
    }
}
