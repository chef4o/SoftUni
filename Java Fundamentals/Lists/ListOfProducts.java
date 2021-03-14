package Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputNumber = Integer.parseInt(scanner.nextLine());

        List<String> input = new ArrayList<>();

        for (int i = 0; i < inputNumber; i++) {
            input.add(i, scanner.nextLine());
        }

        Collections.sort(input);

        for (String product: input) {
            System.out.printf("%d.%s\n", input.indexOf(product) + 1, product);
        }
    }
}
