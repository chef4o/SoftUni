package com.example.springadvquerying.repository;

import com.example.springadvquerying.model.entity.Shampoo;
import com.example.springadvquerying.model.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {

    List<Shampoo> findAllBySizeOrderById(Size size);
    List<Shampoo> findAllBySizeOrLabel_IdOrderByPrice(Size size, Long labelId);
    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);
    Long countAllByPriceLessThan(BigDecimal price);

    @Query("select s from Shampoo s join s.ingredients i where i.name in :names group by s.brand")
    List<Shampoo> findAllByIngredientsNames(@Param(value = "names") List<String> names);

    @Query("select s from Shampoo s where s.ingredients.size < :count")
    Set<Shampoo> findAllByIngredientsLessThan(@Param(value = "count") int count);


}
