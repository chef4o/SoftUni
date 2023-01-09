package com.example.jsonex;

import com.example.jsonex.model.dto.ProductPriceSellerDto;
import com.example.jsonex.service.CategoryService;
import com.example.jsonex.service.ProductService;
import com.example.jsonex.service.UserService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import static com.example.jsonex.constants.GlobalConstants.SAVE_TO_FILE_PATH;
import static com.example.jsonex.constants.GlobalConstants.SAVE_TO_FILE_PRODUCTS;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final BufferedReader reader;
    private final Gson gson;

    public CommandLineRunnerImpl(CategoryService categoryService, UserService userService,
                                 ProductService productService, Gson gson) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.gson = gson;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
        System.out.println("Enter exercise: ");
        int taskNum = Integer.parseInt(reader.readLine());

        switch (taskNum) {
            case 1 -> productsInRange();
        }

    }

    private void productsInRange() throws IOException {
        String outputFileLocation = SAVE_TO_FILE_PATH + SAVE_TO_FILE_PRODUCTS;

        List<ProductPriceSellerDto> productDtos = productService
                .findAllProductsInRangeOrderByPrice(
                        BigDecimal.valueOf(500), BigDecimal.valueOf(1000));

        String content = this.gson.toJson(productDtos);
        writeToFile(outputFileLocation, content);
    }

    private void writeToFile(String outputFileLocation, String content) throws IOException {
        Files.write(
                Path.of(outputFileLocation),
                        Collections.singleton(content));
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        userService.seedUsers();
        productService.seedProducts();
    }
}
