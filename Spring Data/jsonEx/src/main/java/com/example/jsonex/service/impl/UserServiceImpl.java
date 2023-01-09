package com.example.jsonex.service.impl;

import com.example.jsonex.model.dto.UserSeedDto;
import com.example.jsonex.model.entity.User;
import com.example.jsonex.repository.UserRepository;
import com.example.jsonex.service.UserService;
import com.example.jsonex.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.Validator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.jsonex.constants.GlobalConstants.RESOURCES_FILE_NAME_USERS;
import static com.example.jsonex.constants.GlobalConstants.RESOURCES_FILE_PATH;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper model;
    private final Gson gson;

    public UserServiceImpl(UserRepository userRepository, Gson gson, ModelMapper model, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.model = model;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public void seedUsers() throws IOException {
        if (this.userRepository.count() == 0) {
            Arrays.stream(gson.fromJson(
                            Files.readString(
                                    Path.of(RESOURCES_FILE_PATH + RESOURCES_FILE_NAME_USERS)),
                                    UserSeedDto[].class))
                    .filter(validationUtil::isValid)
                    .map(userSeedDto -> {
                        return model.map(userSeedDto, User.class);
                    })
                    .forEach(userRepository::save);
        }
    }

    @Override
    public User findRandomUser() {
        Long randomId = ThreadLocalRandom
                .current()
                .nextLong(1, userRepository.count() + 1);
        return userRepository
                .findById(randomId)
                .orElse(null);
    }
}
