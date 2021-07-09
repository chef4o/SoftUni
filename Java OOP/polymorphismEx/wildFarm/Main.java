package polymorphismEx.wildFarm;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animalList = new ArrayList<>();

        String input;
        while (!(input = scanner.nextLine()).equals("End")) {
            Animal currentAnimal = createAnimal(input);
            currentAnimal.makeSound();
            try {
                currentAnimal.eat(serveFood(scanner.nextLine()));
            } catch (IllegalStateException ise) {
                System.out.println(ise.getMessage());
            }
            animalList.add(currentAnimal);
        }
        animalList.forEach(System.out::println);
    }

    public static Food serveFood(String input) {
        String[] foodDetails = input.split("\\s+");
        String type = foodDetails[0];
        int quantity = Integer.parseInt(foodDetails[1]);
        switch (type) {
            case "Vegetable":
                return new Vegetable(quantity);
            case "Meat":
                return new Meat(quantity);
            default:
                return null;
        }
    }

    public static Animal createAnimal(String input) {
        String[] animalData = input.split("\\s+");

        String type = animalData[0];
        String name = animalData[1];
        double weight = Double.parseDouble(animalData[2]);
        String region = animalData[3];

        switch (type) {
            case "Cat":
                String breed = animalData[4];
                return new Cat(type, name, weight, region, breed);
            case "Tiger":
                return new Tiger(type, name, weight, region);
            case "Zebra":
                return new Zebra(type, name, weight, region);
            case "Mouse":
                return new Mouse(type, name, weight, region);
            default:
                return null;
        }
    }
}
