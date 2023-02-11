package softuni.exam.service.impl;

import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ForecastRootSeedDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Forecast;
import softuni.exam.models.entity.constants.DayOfWeek;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.CityService;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ForecastServiceImpl implements ForecastService {
    private static final String FORECASTS_DATA_FILE = "src/main/resources/files/xml/forecasts.xml";
    private final ForecastRepository forecastRepository;
    private final CityService cityService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    public ForecastServiceImpl(ForecastRepository forecastRepository, CityService cityService, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.forecastRepository = forecastRepository;
        this.cityService = cityService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return Files.readString(Path.of(FORECASTS_DATA_FILE));
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {
        if (!areImported()) {
            StringBuilder output = new StringBuilder();
            xmlParser
                    .fromFile(FORECASTS_DATA_FILE, ForecastRootSeedDto.class)
                    .getForecastSeedDtoList()
                    .stream()
                    .filter(forecastSeedDto -> {
                        boolean isValid = validationUtil.isValid(forecastSeedDto);
                        output.append(getResponse(forecastSeedDto.getDayOfWeek(),
                                forecastSeedDto.getMaxTemperature(), isValid));
                        return isValid;
                    })
                    .map(forecastSeedDto -> {
                        Forecast forecast = modelMapper.map(forecastSeedDto, Forecast.class);
                        City city = cityService.findById(forecastSeedDto.getCity());
                        forecast.setCity(city);
                        return forecast;
                    })
                    .forEach(forecastRepository::save);
            return output.toString().trim();
        }
        return null;
    }

    private String getResponse(DayOfWeek dayOfWeek, Double maxTemp, boolean isValid) {
        return isValid
                ? String.format("Successfully imported forecast %s - %s%s",
                dayOfWeek, maxTemp, System.lineSeparator())
                : String.format("Invalid Player%s", System.lineSeparator());
    }

    @Override
    public String exportForecasts() {
        StringBuilder forecasts = new StringBuilder();
        int citizensCount = 150000;
        DayOfWeek dayOfWeek = DayOfWeek.SUNDAY;
        System.out.println();

        forecastRepository
                .findAllFromSundayWhereCityPopulationBelow(dayOfWeek, citizensCount)
                .forEach(forecast -> {
                    forecasts.append(String.format("City: %s\n",forecast.getCity().getCityName()))
                            .append(String.format("\t-min temperature:  %.2f\n",forecast.getMinTemperature()))
                            .append(String.format("\t--max temperature:  %.2f\n",forecast.getMinTemperature()))
                            .append(String.format("\t---sunrise: %s\n",forecast.getCity().getCityName()))
                            .append(String.format("\t----sunset: %s\n",forecast.getCity().getCityName()))
                            .append(System.lineSeparator());
                });

        return forecasts.toString().trim();
    }
}
