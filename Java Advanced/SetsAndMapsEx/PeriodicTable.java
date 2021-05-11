package SetsAndMapsEx;

import java.util.*;

public class PeriodicTable {
    public static void main(String[] args) {

        Print(ElementsSet());
    }

    public static void Print(Set<String> set) {
        set.forEach(e -> System.out.printf("%s ", e));
    }

    public static Set<String> ElementsSet() {

        Scanner scanner = new Scanner(System.in);

        int inputCycles = Integer.parseInt(scanner.nextLine());
        Set<String> set = new TreeSet<>();
        while (inputCycles-- > 0) {

            String[] currentLine = scanner.nextLine().split("\\s+");
            set.addAll(Arrays.asList(currentLine));
        }
        return set;
    }
}