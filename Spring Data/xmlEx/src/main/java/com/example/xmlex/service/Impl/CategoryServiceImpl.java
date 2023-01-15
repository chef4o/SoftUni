package com.example.xmlex.service.Impl;

import com.example.xmlex.model.dto.CategorySeedDto;
import com.example.xmlex.model.entity.Category;
import com.example.xmlex.repository.CategoryRepository;
import com.example.xmlex.service.CategoryService;
import com.example.xmlex.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedCategories(List<CategorySeedDto> categories) {
            categories
                    .stream()
                    .filter(this.validationUtil::isValid)
                    .map(categorySeedDto -> modelMapper
                            .map(categorySeedDto, Category.class))
                    .forEach(this.categoryRepository::save);
    }

    @Override
    public long getEntityCount() {
        return this.categoryRepository.count();
    }
}
