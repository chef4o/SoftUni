package AssociativeArrays;

import java.util.Arrays;
import java.util.Scanner;

public class WordFilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = Arrays.stream(scanner.nextLine().split(" "))
                .filter(a -> a.length() % 2 == 0)
                .toArray(String[]::new);

        for(String item:input) {
            System.out.println(item);
        }
    }
}
