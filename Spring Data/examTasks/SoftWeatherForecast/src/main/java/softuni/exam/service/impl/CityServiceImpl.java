package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CitySeedDto;
import softuni.exam.models.entity.City;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CityService;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {
    private static final String CITIES_DATA_FILE = "src/main/resources/files/json/cities.json";
    private final CityRepository cityRepository;
    private final CountryService countryService;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final CountryRepository countryRepository;

    public CityServiceImpl(CityRepository cityRepository, CountryService countryService, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil,
                           CountryRepository countryRepository) {
        this.cityRepository = cityRepository;
        this.countryService = countryService;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.countryRepository = countryRepository;
    }

    @Override
    public boolean areImported() {
        return this.cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return Files.readString(Path.of(CITIES_DATA_FILE));
    }

    @Override
    public String importCities() throws IOException {
        if (!areImported()) {
            StringBuilder output = new StringBuilder();
            Arrays.stream(gson
                            .fromJson(readCitiesFileContent(), CitySeedDto[].class))
                    .filter(citySeedDto -> {
                        boolean isValid = validationUtil.isValid(citySeedDto)
                                && isNonExistingEntity(citySeedDto.getCityName());;
                        output.append(getResponse(citySeedDto.getCityName(),
                                citySeedDto.getPopulation(), isValid));
                        return isValid;
                    })
                    .map(citySeedDto -> {
                        City city = modelMapper.map(citySeedDto, City.class);
                        city.setCountry(countryService.findById(citySeedDto.getCountry()));
                        return city;
                    })
                    .forEach(cityRepository::save);

            return output.toString().trim();
        }
        return null;
    }

    @Override
    public City findById(Long city) {
        return cityRepository.findById(city).orElse(null);
    }

    private boolean isNonExistingEntity(String cityName) {
        return !cityRepository.existsByCityName(cityName);
    }

    private String getResponse(String name, Integer population, boolean isValid) {
        return isValid
                ? String.format("Successfully imported city %s - %s%s",
                name, population, System.lineSeparator())
                : String.format("Invalid city%s", System.lineSeparator());
    }
}
