package SetsAndMapsEx;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> collection = new LinkedHashMap<>();

        String input;
        while (!"stop".equals(input = scanner.nextLine())) {

            collection.put(input, scanner.nextLine());

            if (collection.get(input).toLowerCase().contains(".us")
                    || collection.get(input).toLowerCase().contains(".uk")
                    || collection.get(input).toLowerCase().contains(".com")) {
                collection.remove(input);
            }
        }

        collection.forEach((k, v) -> System.out.printf("%s -> %s\n", k, v));
    }
}
