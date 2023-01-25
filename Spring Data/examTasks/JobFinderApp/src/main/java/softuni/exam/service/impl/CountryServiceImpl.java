package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountrySeedDto;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class CountryServiceImpl implements CountryService {
    private static final String COUNTRIES_SEED_FILE_JSON = "src/main/resources/files/json/countries.json";
    private final CountryRepository countryRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public CountryServiceImpl(CountryRepository countryRepository, ValidationUtil validationUtil,
                              ModelMapper modelMapper, Gson gson) {
        this.countryRepository = countryRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFileContent() throws IOException {
        return Files.readString(Path.of(COUNTRIES_SEED_FILE_JSON));
    }

    @Override
    public String importCountries() throws IOException {
        if (!areImported()) {
            StringBuilder output = new StringBuilder();
            Arrays.stream(gson
                            .fromJson(readCountriesFileContent(), CountrySeedDto[].class))
                    .filter(countrySeedDto -> {
                        boolean isValid = validationUtil.isValid(countrySeedDto)
                                && isNonExistingEntity(countrySeedDto.getName(), countrySeedDto.getCountryCode());
                        System.out.println();
                        output.append(generateSeedResponse(countrySeedDto.getName(),
                                countrySeedDto.getCountryCode(), isValid));
                        return isValid;
                    })
                    .map(countrySeedDto -> modelMapper.map(countrySeedDto, Country.class))
                    .forEach(countryRepository::save);

            return output.toString().trim();
        }
        return null;
    }

    @Override
    public Country findById(Long country) {
        return countryRepository.findById(country).orElse(null);
    }

    private boolean isNonExistingEntity(String name, String code) {
        return !countryRepository.existsByName(name) && !countryRepository.existsByCode(code);
    }


    private String generateSeedResponse(String name, String code, boolean isValid) {
        return isValid
                ? String.format("Successfully imported country %s - %s%s",
                name, code, System.lineSeparator())
                : String.format("Invalid country%s", System.lineSeparator());
    }
}
