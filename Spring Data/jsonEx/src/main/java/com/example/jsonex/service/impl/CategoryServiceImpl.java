package com.example.jsonex.service.impl;

import com.example.jsonex.model.dto.CategorySeedDto;
import com.example.jsonex.model.entity.Category;
import com.example.jsonex.repository.CategoryRepository;
import com.example.jsonex.service.CategoryService;
import com.example.jsonex.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.jsonex.constants.GlobalConstants.*;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public void seedCategories() throws IOException {
        if (categoryRepository.count() > 0) {
            return;
        }

        String fileContent = Files
                .readString(Path.of(RESOURCES_FILE_PATH + RESOURCES_FILE_NAME_CATEGORIES));

        CategorySeedDto[] categorySeedDtos = gson.fromJson(fileContent, CategorySeedDto[].class);

        Arrays.stream(categorySeedDtos)
                .filter(validationUtil::isValid)
                .map(entry -> modelMapper.map(entry, Category.class))
                .forEach(categoryRepository::save);
    }

    @Override
    public Set<Category> getRandomCategories() {
        Set<Category> categorySet = new HashSet<>();
        int categoriesCount = ThreadLocalRandom
                              .current()
                              .nextInt(1, 4);

        long totalCategoriesCount = this.categoryRepository.count() + 1;
        for (int i = 0; i < categoriesCount; i++) {
            long randomCategoryId = ThreadLocalRandom
                                    .current()
                                    .nextLong(1, totalCategoriesCount);
            categorySet.add(categoryRepository
                            .findById(randomCategoryId)
                            .orElse(null));
        }
        return categorySet;
    }
}
