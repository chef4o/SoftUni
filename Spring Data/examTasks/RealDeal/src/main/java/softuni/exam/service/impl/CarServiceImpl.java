package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.constants.GlobalConstraints;
import softuni.exam.models.dto.CarSeedDto;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper,
                          Gson gson, ValidationUtil validationUtil) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return Files.readString(Path.of(GlobalConstraints.RESOURCES_JSON_CARS_PATH));
    }

    @Override
    public String importCars() throws IOException {

        if (!areImported()) {
            StringBuilder strBuilder = new StringBuilder();

            Arrays.stream(gson
                            .fromJson(readCarsFileContent(), CarSeedDto[].class))
                    .filter(carSeedDto -> {
                        boolean isValid = validationUtil.isValid(carSeedDto);
                        strBuilder.append(generateSeedResponse(carSeedDto.getMake(), carSeedDto.getModel(), isValid));
                        return isValid; })
                    .map(carSeedDto -> modelMapper.map(carSeedDto, Car.class))
                    .forEach(carRepository::save);

            return strBuilder.toString().trim();
        }
        return null;
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {
        StringBuilder sb = new StringBuilder();
        carRepository
                .findAllByIdOrderByPicturesCountThenByMake()
                .forEach(car -> {
                    sb.append(String.format("Car make - %s, model - %s\n" +
                            "\tKilometers - %d\n" +
                            "\tRegistered on - %s\n" +
                            "\tNumber of pictures - %d",
                            car.getMake(), car.getModel(),
                            car.getKilometers(),
                            car.getRegisteredOn(),
                            car.getPictures().size()
                    )).append(System.lineSeparator());
                });
        return sb.toString();
    }

    @Override
    public Car findById(Long carId) {
        return carRepository.findById(carId).orElse(null);
    }

    private String generateSeedResponse(String carMake, String carModel, boolean isValid) {
        return isValid
                ? String.format("Successfully imported car - %s - %s%s",
                                carMake, carModel, System.lineSeparator())
                : String.format("Invalid car%s", System.lineSeparator());
    }
}
