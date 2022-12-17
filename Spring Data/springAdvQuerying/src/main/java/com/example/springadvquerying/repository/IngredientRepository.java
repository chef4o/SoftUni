package com.example.springadvquerying.repository;

import com.example.springadvquerying.model.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findAllByNameStartingWith(String firstLetter);
    List<Ingredient> findAllByNameInOrderByPrice(List<String> ingredients);

    @Query("delete from Ingredient i where i.name = :name")
    @Modifying
    void deleteIngredientsByName(@Param(value = "name") String name);

    @Query("update Ingredient i set i.price = i.price * (1 + (:percentage / 100))")
    @Modifying
    int increaseAllPricesBy(@Param(value = "percentage") int percentage);

    @Query("update Ingredient i set i.price = i.price * (1 + (:percentage / 100)) where i.name in :ingredients")
    @Modifying
    int increaseFromPricesBy(@Param(value = "ingredients") List<String> ingredients,
                             @Param(value = "percentage") int percentage);
}
