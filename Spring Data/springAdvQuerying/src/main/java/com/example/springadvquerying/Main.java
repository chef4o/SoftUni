package com.example.springadvquerying;

import com.example.springadvquerying.model.entity.Size;
import com.example.springadvquerying.service.IngredientService;
import com.example.springadvquerying.service.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.in;

@Component
public class Main implements CommandLineRunner {

    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    public Main(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        System.out.println("Please enter a query ID:");
        int query = Integer.parseInt(reader.readLine());
        executeQuery(query, reader);
    }

    private void executeQuery(int queryId, BufferedReader reader) throws IOException {
        switch (queryId) {
            case 1 -> {
                System.out.println("Please input shampoo size: " + Arrays.toString(Size.class.getEnumConstants()));
                String size = reader.readLine().toUpperCase();
                getShampoosBySize(size);
            }
            case 2 -> {
                System.out.println("Please input shampoo size: " + Arrays.toString(Size.class.getEnumConstants()));
                String size = reader.readLine().toUpperCase();
                System.out.println("Please input a labelId:");
                long label = Long.parseLong(reader.readLine().toUpperCase());
                getShampooBySizeOrLabelId(size, label);
            }
            case 3 -> {
                System.out.println("Please input a price:");
                BigDecimal price = new BigDecimal(reader.readLine());
                getShampoosByPrice(price);
            }
            case 4 -> {
                System.out.println("Please input a starting letter:");
                String startingLetter = reader.readLine();
                getIngredientsByStartingLetter(startingLetter);
            }
            case 5 -> {
                System.out.println("Please input ingredient names separated by a single space:");
                List<String> ingredients = Arrays.asList(reader.readLine().split("\\s+"));
                getIngredientsFromList(ingredients);
            }
            case 6 -> {
                System.out.println("Please input a price:");
                BigDecimal price = new BigDecimal(reader.readLine());
                countShampoosWithPriceBelow(price);
            }
            case 7 -> {
                System.out.println("Please input ingredient names separated by a single space:");
                List<String> ingredients = Arrays.asList(reader.readLine().split("\\s+"));
                getShampoosByIngredients(ingredients);
            }
            case 8 -> {
                System.out.println("Please input ingredients count:");
                int count = Integer.parseInt(reader.readLine());
                getShampoosByIngredientsLessThan(count);
            }
            case 9 -> {
                System.out.println("Please input ingredient for deletion:");
                String ingredientName = reader.readLine();
                deleteIngredientsByName(ingredientName);
                System.out.println(ingredientName + " successfully deleted");
            }
            case 10 -> {
                System.out.println("Please input increase percentage for all ingredients prices:");
                int percentage = Integer.parseInt(reader.readLine());
                int result = increaseAllIngredientsPrices(percentage);
                System.out.println(result + " records updated");
            }
            case 11 -> {
                System.out.println("Please input increase percentage for all ingredients prices:");
                int percentage = Integer.parseInt(reader.readLine());
                System.out.println("Please input ingredient names separated by a single space:");
                List<String> ingredients = Arrays.asList(reader.readLine().split("\\s+"));
                int result = increaseSelectedIngredientsPrices(ingredients, percentage);
                System.out.println(result + " records updated");
            }
            default -> throw new IllegalArgumentException("No such task exists");

        }
    }

    private int increaseSelectedIngredientsPrices(List<String> ingredients, int percentage) {
        return this.ingredientService.updateIngredientsFromListWithPercentage(ingredients, percentage);
    }

    private int increaseAllIngredientsPrices(int percentage) {
        return this.ingredientService.increaseAllPricesBy(percentage);
    }

    private void deleteIngredientsByName(String ingredientName) {
        this.ingredientService.deleteAllByName(ingredientName);
    }

    private void getShampoosByIngredientsLessThan(int count) {
        this.shampooService.getAllByIngredientsLessThan(count)
                .forEach(System.out::println);
    }

    private void getShampoosByIngredients(List<String> ingredients) {
        this.shampooService.getAllByIngredients(ingredients)
                .forEach(System.out::println);
    }

    private void countShampoosWithPriceBelow(BigDecimal price) {
        System.out.println(this.shampooService.countAllByPrice(price));
    }

    private void getIngredientsFromList(List<String> ingredients) {
        this.ingredientService.getAllFromList(ingredients)
                .forEach(System.out::println);
    }

    private void getIngredientsByStartingLetter(String startingLetter) {
        this.ingredientService.getAllByFirstLetter(startingLetter)
                .forEach(i -> System.out.println(i.getName()));
    }

    private void getShampoosByPrice(BigDecimal price) {
        this.shampooService.getAllByPrice(price)
                .forEach(s -> System.out.println(s.toString()));
    }

    private void getShampoosBySize(String shampooSize) {
        this.shampooService.getAllBySize(getSizeEnum(shampooSize))
                .forEach(s -> System.out.println(s.toString()));
    }

    private Size getSizeEnum(String size) {
        switch (size) {
            case "SMALL" -> { return Size.SMALL; }
            case "MEDIUM" -> { return Size.MEDIUM; }
            case "LARGE" -> { return Size.LARGE; }
            default -> throw new IllegalStateException("Unexpected value: " + size);
        }
    }

    private void getShampooBySizeOrLabelId(String size, Long labelId) {
        this.shampooService.getAllBySizeOrLabelId(getSizeEnum(size), labelId)
                .forEach(s -> System.out.println(s.toString()));
    }
}
