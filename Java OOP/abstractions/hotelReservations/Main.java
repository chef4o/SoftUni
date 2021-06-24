package abstractions.hotelReservations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main  {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] command = inputParser(reader.readLine(), "\\s+");

        priceCalculator calc = new priceCalculator(Double.parseDouble(command[0]),
                Integer.parseInt(command[1]),
                season.valueOf(command[2].toUpperCase()),
                discountType.valueOf(command[3].toUpperCase()));

        System.out.printf("%.2f\n", calc.makeCalculations());
    }

    public static String[] inputParser (String input, String spliterator) {
        return input.split(spliterator);
    }

}
