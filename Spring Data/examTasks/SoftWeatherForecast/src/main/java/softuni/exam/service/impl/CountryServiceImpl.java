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

    private static final String COUNTRIES_DATA_FILE = "src/main/resources/files/json/countries.json";
    private final CountryRepository countryRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public CountryServiceImpl(CountryRepository countryRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return Files.readString(Path.of(COUNTRIES_DATA_FILE));
    }

    @Override
    public String importCountries() throws IOException {
        if (!areImported()) {
            StringBuilder output = new StringBuilder();
            Arrays.stream(gson
                            .fromJson(readCountriesFromFile(), CountrySeedDto[].class))
                    .filter(countrySeedDto -> {
                        boolean isValid = validationUtil.isValid(countrySeedDto)
                                && isNonExistingEntity(countrySeedDto.getCountryName());
                        output.append(getResponse(countrySeedDto.getCountryName(),
                                countrySeedDto.getCurrency(), isValid));
                        return isValid;
                    })
                    .map(countrySeedDto -> modelMapper.map(countrySeedDto, Country.class))
                    .forEach(countryRepository::save);

            return output.toString().trim();
        }
        return null;
    }

    private boolean isNonExistingEntity(String countryName) {
        return !countryRepository.existsByCountryName(countryName);
    }

    @Override
    public Country findById(Long countryId) {
        return countryRepository.findById(countryId).orElse(null);
    }

    private String getResponse(String name, String currency, boolean isValid) {
        return isValid
                ? String.format("Successfully imported country %s - %s%s",
                name, currency, System.lineSeparator())
                : String.format("Invalid country%s", System.lineSeparator());
    }

}
