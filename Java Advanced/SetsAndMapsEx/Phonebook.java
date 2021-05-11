package SetsAndMapsEx;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new TreeMap<>();

        String input;
        while (!"search".equals(input = scanner.nextLine())) {

            String[] inputData = input.split("-");

            if (!phonebook.containsKey(inputData[0])) {
                phonebook.put(inputData[0], inputData[1]);
            } else {
                phonebook.replace(inputData[0], inputData[1]);
            }
        }

        while (!"stop".equals(input = scanner.nextLine())) {

            if (phonebook.containsKey(input)) {
                System.out.printf("%s -> %s\n", input, phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.\n", input);
            }
        }
    }
}
