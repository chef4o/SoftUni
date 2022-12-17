package com.example.springadvquerying.service;

import com.example.springadvquerying.model.entity.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> getAllByFirstLetter(String startingLetter);
    List<Ingredient> getAllFromList(List<String> ingredients);
    void deleteAllByName(String ingredientName);
    int increaseAllPricesBy(int percentage);
    int updateIngredientsFromListWithPercentage(List<String> ingredients, int percentage);
}
