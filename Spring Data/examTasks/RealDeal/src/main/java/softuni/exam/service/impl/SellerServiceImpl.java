package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.constants.GlobalConstraints;
import softuni.exam.models.dto.SellerSeedRootDto;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class SellerServiceImpl implements SellerService {

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final SellerRepository sellerRepository;

    public SellerServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, SellerRepository sellerRepository) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.sellerRepository = sellerRepository;
    }


    @Override
    public boolean areImported() {
        return sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return Files.readString(Path.of(GlobalConstraints.RESOURCES_XML_SELLERS_PATH));
    }

    @Override
    public String importSellers() throws IOException, jakarta.xml.bind.JAXBException {
        StringBuilder strBuilder = new StringBuilder();

        if (!areImported()) {
            xmlParser
                    .fromFile(GlobalConstraints.RESOURCES_XML_SELLERS_PATH, SellerSeedRootDto.class)
                    .getSellers()
                    .stream()
                    .filter(sellerSeedDto -> {
                        boolean isValid = validationUtil.isValid(sellerSeedDto);
                        strBuilder.append(generateSeedResponse(
                                sellerSeedDto.getLastName(), sellerSeedDto.getEmail(), isValid));
                        return isValid;
                    })
                    .map(sellerSeedDto -> modelMapper.map(sellerSeedDto, Seller.class))
                    .forEach(sellerRepository::save);

            return strBuilder.toString().trim();
        }

        return null;
    }

    @Override
    public Seller findById(Long id) {
        return sellerRepository.findById(id).orElse(null);
    }

    private String generateSeedResponse(String lastName, String email, boolean isValid) {
        return isValid
                ? String.format("Successfully imported seller %s - %s%s",
                lastName, email, System.lineSeparator())
                : String.format("Invalid seller%s", System.lineSeparator());
    }
}

