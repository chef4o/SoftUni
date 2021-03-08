package MidExam;

import java.util.*;

public class AngryPet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] intArray =
                Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int startingPoint = Integer.parseInt(scanner.nextLine());
        String typeOfItems = scanner.nextLine();
        String priceRatingAim = scanner.nextLine();

        int leftSum = 0;
        for (int i = startingPoint - 1; i >= 0; i--) {

            switch (typeOfItems) {
                case "cheap":
                    if (intArray[i] < intArray[startingPoint]) {
                        leftSum += calculatePriceByRating(priceRatingAim, intArray[i]);
                    }
                    break;

                case "expensive":
                    if (intArray[i] >= intArray[startingPoint]) {
                        leftSum += calculatePriceByRating(priceRatingAim, intArray[i]);
                    }
                    break;
            }
        }

        int rightSum = 0;
        for (int i = startingPoint + 1; i < intArray.length; i++) {

            switch (typeOfItems) {
                case "cheap":
                    if (intArray[i] < intArray[startingPoint]) {
                        rightSum += calculatePriceByRating(priceRatingAim, intArray[i]);
                    }
                    break;

                case "expensive":
                    if (intArray[i] >= intArray[startingPoint]) {
                        rightSum += calculatePriceByRating(priceRatingAim, intArray[i]);
                    }
                    break;
            }
        }

        if (rightSum > leftSum) {
            System.out.printf("Right - %d", rightSum);
        } else {
            System.out.printf("Left - %d", leftSum);
        }

    }

    static int calculatePriceByRating (String ratingAim, int currentIndex) {

        int price = 0;

        switch (ratingAim) {
            case "positive":
                if (currentIndex > 0) {
                    price += currentIndex;
                }
                break;
            case "negative":
                if (currentIndex < 0) {
                    price += currentIndex;
                }
                break;
            case "all":
                price += currentIndex;
                break;
        }

        return price;
    }
}
