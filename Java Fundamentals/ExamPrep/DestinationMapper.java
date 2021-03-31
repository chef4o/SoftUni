package ExamPrep;

import java.util.*;
import java.util.regex.*;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String expression = "(?<prefix>[=/])(?<City>[A-Z][a-z]+)\\1";

        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(input);

        List<String> cities = new ArrayList<>();

        while (matcher.find()) {
            cities.add(matcher.group("City"));
        }

        if (cities.size() > 0) {
            System.out.printf("Destinations: %s\n", String.join(", ", cities));
        } else {
            System.out.printf("Destinations: %s\n", String.join(", ", cities));
        }

        System.out.printf("Travel Points: %d\n", String.join("", cities).length());
    }
}
