package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CompanySeedRootDto;
import softuni.exam.models.entity.Company;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CompanyRepository;
import softuni.exam.service.CompanyService;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class CompanyServiceImpl implements CompanyService {
    private static final String COMPANIES_SEED_XML_FILE = "src/main/resources/files/xml/companies.xml";
    private final CompanyRepository companyRepository;
    private final CountryService countryService;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CompanyServiceImpl(CompanyRepository companyRepository, CountryService countryService,
                              XmlParser xmlParser, ValidationUtil validationUtil,
                              ModelMapper modelMapper) {
        this.companyRepository = companyRepository;
        this.countryService = countryService;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return companyRepository.count() > 0;
    }

    @Override
    public String readCompaniesFromFile() throws IOException {
        return Files.readString(Path.of(COMPANIES_SEED_XML_FILE));
    }

    @Override
    public String importCompanies() throws IOException, JAXBException {
        if (!areImported()) {
            StringBuilder strBuilder = new StringBuilder();

            xmlParser
                    .fromFile(COMPANIES_SEED_XML_FILE, CompanySeedRootDto.class)
                    .getCompanySeedDtoList()
                    .stream()
                    .filter(companySeedDto -> {
                        boolean isValid = validationUtil.isValid(companySeedDto)
                                && isNonExistingEntity(companySeedDto.getCompanyName())
                                && countryService.findById(companySeedDto.getCountryId()) != null;
                        strBuilder.append(generateSeedResponse(
                                companySeedDto.getCompanyName(), companySeedDto.getCountryId(), isValid));
                        return isValid;
                    })
                    .map(companySeedDto -> {
                        Company company = modelMapper.map(companySeedDto, Company.class);
                        Country country = countryService.findById(companySeedDto.getCountryId());
                        company.setCountry(country);
                        return company;
                    })
                    .forEach(companyRepository::save);
            return strBuilder.toString().trim();
        }
        return null;
    }

    @Override
    public Company findById(Long companyId) {
        return companyRepository.findById(companyId).orElse(null);
    }

    private boolean isNonExistingEntity(String companyName) {
        return !companyRepository.existsByName(companyName);
    }

    private String generateSeedResponse(String name, Long countryId, boolean isValid) {
        return isValid
                ? String.format("Successfully imported company %s - %s%s",
                name, countryId, System.lineSeparator())
                : String.format("Invalid company%s", System.lineSeparator());
    }
}
