package SetsAndMapsEx;

import java.util.*;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputs = Integer.parseInt(scanner.nextLine());

        Set<String> output = new LinkedHashSet<>();

        while (inputs-- > 0) {
            output.add(scanner.nextLine());
        }

        output.forEach(System.out::println);
    }
}
