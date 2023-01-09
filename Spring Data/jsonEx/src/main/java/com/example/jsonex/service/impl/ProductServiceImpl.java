package com.example.jsonex.service.impl;

import com.example.jsonex.model.dto.ProductPriceSellerDto;
import com.example.jsonex.model.dto.ProductSeedDto;
import com.example.jsonex.model.entity.Product;
import com.example.jsonex.repository.ProductRepository;
import com.example.jsonex.service.CategoryService;
import com.example.jsonex.service.ProductService;
import com.example.jsonex.service.UserService;
import com.example.jsonex.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.jsonex.constants.GlobalConstants.*;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ValidationUtil validationUtil;
    private final ModelMapper model;
    private final Gson gson;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, UserService userService, ValidationUtil validationUtil, ModelMapper model, Gson gson) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.userService = userService;
        this.validationUtil = validationUtil;
        this.model = model;
        this.gson = gson;
    }

    @Override
    public void seedProducts() throws IOException {
        String fileContent = Files
                .readString(Path.of(RESOURCES_FILE_PATH + RESOURCES_FILE_NAME_PRODUCTS));

        ProductSeedDto[] productSeedDtos = gson
                .fromJson(fileContent, ProductSeedDto[].class);

        Set<ConstraintViolation<ProductSeedDto[]>> violations =
                validationUtil.getViolations(productSeedDtos);

        if (!violations.isEmpty()) {
            violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        Arrays.stream(productSeedDtos)
                .filter(validationUtil::isValid)
                .map(productSeedDto -> {
                    Product product = model.map(productSeedDto, Product.class);
                    product.setSeller(this.userService.findRandomUser());
                    product.setBuyer(this.userService.findRandomUser());
                    product.setCategories(this.categoryService.getRandomCategories());
                    return product;
                })
                .forEach(this.productRepository::save);

    }

    @Override
    public List<ProductPriceSellerDto> findAllProductsInRangeOrderByPrice(BigDecimal valueFrom, BigDecimal valueTo) {
        return this.productRepository
                .findAllByPriceBetweenOrderByPrice(valueFrom, valueTo)
                .stream()
                .map(product -> {
                    ProductPriceSellerDto productPriceSellerDto =
                            this.model.map(product, ProductPriceSellerDto.class);
                    productPriceSellerDto.setSeller(
                            String.format("%s %s",
                                    product.getSeller().getFirstName(),
                                    product.getSeller().getLastName()));
                    return productPriceSellerDto;
                })
                .collect(Collectors.toList());
    }
}
