package com.example.xmlex.service;

import com.example.xmlex.model.dto.CategorySeedDto;

import java.util.List;

public interface CategoryService {
    void seedCategories(List<CategorySeedDto> categories);
    long getEntityCount();
}
