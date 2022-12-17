package com.example.springadvquerying.service;

import com.example.springadvquerying.model.entity.Ingredient;
import com.example.springadvquerying.repository.IngredientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> getAllByFirstLetter(String startingLetter) {
        return this.ingredientRepository.findAllByNameStartingWith(startingLetter);
    }

    @Override
    public List<Ingredient> getAllFromList(List<String> ingredients) {
        return this.ingredientRepository.findAllByNameInOrderByPrice(ingredients);
    }

    @Override
    @Transactional
    public void deleteAllByName(String ingredientName) {
        this.ingredientRepository.deleteIngredientsByName(ingredientName);
    }

    @Override
    @Transactional
    public int increaseAllPricesBy(int percentage) {
        return this.ingredientRepository.increaseAllPricesBy(percentage);
    }

    @Override
    @Transactional
    public int updateIngredientsFromListWithPercentage(List<String> ingredients, int percentage) {
        return this.ingredientRepository.increaseFromPricesBy(ingredients, percentage);
    }
}
