package FirstStepsInCodingEx;

import java.util.Scanner;

public class FishMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        short length = Short.parseShort(scanner.nextLine());
        short width = Short.parseShort(scanner.nextLine());
        short height = Short.parseShort(scanner.nextLine());
        double addonsVolume = Double.parseDouble(scanner.nextLine());
        double aquariumVolume = (length * width * height) * (1 - addonsVolume / 100d);

        double waterVolume = aquariumVolume / 1000d; ;

        System.out.printf("%.2f", waterVolume);
    }
}