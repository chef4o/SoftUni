package softuni.exam.service.impl;

import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.constants.GlobalConstraints;
import softuni.exam.models.dto.OfferSeedRootDto;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.OfferService;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class OfferServiceImpl implements OfferService {
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final OfferRepository offerRepository;
    private final CarService carService;
    private final SellerService sellerService;

    public OfferServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil,
                            XmlParser xmlParser, OfferRepository offerRepository, CarService carService, SellerService sellerService) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.offerRepository = offerRepository;
        this.carService = carService;
        this.sellerService = sellerService;
    }

    @Override
    public boolean areImported() {
        return offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(GlobalConstraints.RESOURCES_XML_OFFERS_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {

        if (!areImported()) {
            StringBuilder strBuilder = new StringBuilder();

            xmlParser
                    .fromFile(GlobalConstraints.RESOURCES_XML_OFFERS_PATH, OfferSeedRootDto.class)
                    .getOffers()
                    .stream()
                    .filter(offerSeedDto -> {
                        boolean isValid = validationUtil.isValid(offerSeedDto);
                        strBuilder.append(generateSeedResponse(
                                offerSeedDto.getAddedOn(), offerSeedDto.getHasGoldStatus(), isValid));
                        return isValid;
                    })
                    .map(offerSeedDto -> {
                        Offer offer = modelMapper.map(offerSeedDto, Offer.class);
                        offer.setCar(carService.findById(offerSeedDto.getCar().getId()));
                        offer.setSeller(sellerService.findById(offerSeedDto.getSeller().getId()));
                        return offer;
                    })
                    .forEach(offerRepository::save);
            return strBuilder.toString().trim();
        }
        return null;
    }

    private String generateSeedResponse(String addedOn, Boolean hasGoldStatus, boolean isValid) {
        return isValid
                ? String.format("Successfully imported offer %s - %s%s",
                addedOn, hasGoldStatus, System.lineSeparator())
                : String.format("Invalid offer%s", System.lineSeparator());
    }
}
