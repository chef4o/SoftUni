package com.example.springadvquerying.service;

import com.example.springadvquerying.model.entity.Shampoo;
import com.example.springadvquerying.model.entity.Size;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface ShampooService {
    List<Shampoo> getAllBySize(Size size);
    List<Shampoo> getAllBySizeOrLabelId(Size size, Long labelId);
    List<Shampoo> getAllByPrice(BigDecimal price);
    Long countAllByPrice(BigDecimal price);
    List<String> getAllByIngredients(List<String> ingredients);
    Set<String> getAllByIngredientsLessThan(int count);
}
