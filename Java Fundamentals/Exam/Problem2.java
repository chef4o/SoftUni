package Exam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String expression = "^(\\$|%)(?<tag>[A-Z][a-z]{2,})\\1: \\[(?<char1>\\d+)\\]\\|\\[(?<char2>\\d+)\\]\\|\\[(?<char3>\\d+)\\]\\|$";

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            Pattern pattern = Pattern.compile(expression);
            Matcher matcher = pattern.matcher(input);

            int foundOccurrences = 0;

            while (matcher.find()) {

                char one = (char)Integer.parseInt(matcher.group("char1"));
                char two = (char)Integer.parseInt(matcher.group("char2"));
                char three = (char)Integer.parseInt(matcher.group("char3"));

                String decipher = String.valueOf(one) + two + three;
                System.out.printf("%s: %s\n", matcher.group("tag"), decipher);
                foundOccurrences++;
            }

            if (foundOccurrences == 0) {
                System.out.println("Valid message not found!");
            }
        }
    }
}
