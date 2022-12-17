package com.example.springadvquerying.service;

import com.example.springadvquerying.model.entity.Shampoo;
import com.example.springadvquerying.model.entity.Size;
import com.example.springadvquerying.repository.ShampooRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShampooServiceImpl implements ShampooService {

    private final ShampooRepository shampooRepository;

    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<Shampoo> getAllBySize(Size size) {
        return this.shampooRepository
                .findAllBySizeOrderById(size);
    }

    @Override
    public List<Shampoo> getAllBySizeOrLabelId(Size size, Long labelId) {
        return this.shampooRepository
                .findAllBySizeOrLabel_IdOrderByPrice(size, labelId);
    }

    @Override
    public List<Shampoo> getAllByPrice(BigDecimal price) {
        return this.shampooRepository
                .findAllByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override
    public Long countAllByPrice(BigDecimal price) {
        return this.shampooRepository.countAllByPriceLessThan(price);
    }

    @Override
    public List<String> getAllByIngredients(List<String> ingredients) {
        return this.shampooRepository.findAllByIngredientsNames(ingredients)
                                        .stream()
                                        .map(Shampoo::getBrand)
                                        .collect(Collectors.toList());
    }

    @Override
    public Set<String> getAllByIngredientsLessThan(int count) {
        return this.shampooRepository.findAllByIngredientsLessThan(count)
                .stream()
                .map(Shampoo::getBrand)
                .collect(Collectors.toSet());
    }
}
