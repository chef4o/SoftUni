package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.constants.GlobalConstraints;
import softuni.exam.models.dto.PictureSeedDto;
import softuni.exam.models.entity.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.PictureService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;
    private final CarService carService;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public PictureServiceImpl(PictureRepository pictureRepository, CarService carService, ModelMapper modelMapper,
                              Gson gson, ValidationUtil validationUtil) {
        this.pictureRepository = pictureRepository;
        this.carService = carService;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return Files.readString(Path.of(GlobalConstraints.RESOURCES_JSON_PICTURES_PATH));
    }

    @Override
    public String importPictures() throws IOException {

        StringBuilder strBuilder = new StringBuilder();

        Arrays.stream(gson
                        .fromJson(readPicturesFromFile(), PictureSeedDto[].class))
                .filter(pictureSeedDto -> {
                    boolean isValid = validationUtil.isValid(pictureSeedDto);
                    strBuilder.append(generateSeedResponse(pictureSeedDto.getName(), isValid));
                    return isValid;
                })
                .map(pictureSeedDto -> {
                    Picture picture = modelMapper.map(pictureSeedDto, Picture.class);
                    picture.setCar(carService.findById(pictureSeedDto.getCar()));
                    return picture;
                })
                .forEach(pictureRepository::save);

        return strBuilder.toString().trim();
    }

    private String generateSeedResponse(String name, boolean isValid) {
        return isValid
                ? String.format("Successfully imported picture - %s%s",
                name, System.lineSeparator())
                : String.format("Invalid picture%s", System.lineSeparator());
    }
}
