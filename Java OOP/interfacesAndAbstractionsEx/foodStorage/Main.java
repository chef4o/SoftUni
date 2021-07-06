package interfacesAndAbstractionsEx.foodStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());

        List<Buyer> buyersDatabase = new ArrayList<>();
        while (people-- > 0) {
            String[] buyerDetails = scanner.nextLine().split("\\s+");
            buyersDatabase.add(newBuyer(buyerDetails));
        }

        String input;
        while (!(input = scanner.nextLine()).equals("End")) {
                shopForFood(input, buyersDatabase);
        }

        System.out.println(countFood(buyersDatabase));
    }

    public static int countFood (List<Buyer> allBuyers) {
        return allBuyers.stream().mapToInt(Buyer::getFood).sum();
    }

    public static void shopForFood(String buyer, List<Buyer> buyersList) {
        for (Buyer person : buyersList) {
            if (person.getName().equals(buyer)) {
                person.buyFood();
                break;
            }
        }
    }

    public static Buyer newBuyer(String[] person) {
        String name = person[0];
        int age = Integer.parseInt(person[1]);
        String  specialDetail = person[2];

        if (isCitizen(person)) {
            String birthDate = person[3];
            return new Citizen(name, age, specialDetail, birthDate);
        } else if (isRebel(person)) {
            return new Rebel(name, age, specialDetail);
        } else {
            throw new IllegalArgumentException("Invalid entry");
        }
    }

    public static boolean isCitizen(String[] person) {
        return person.length == 4;
    }

    public static boolean isRebel(String[] person) {
        return person.length == 3;
    }
}
