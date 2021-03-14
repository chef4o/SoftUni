package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipuationAdvance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list =
                Arrays.stream(scanner.nextLine()
                        .split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            String[] command = input.split(" ");
            switch (command[0]) {
                case "Contains":
                    if (list.contains(Integer.valueOf(command[1]))) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    printEvenOrOddNumbers(list, command[1]);
                    break;
                case "Get":
                    int sum = 0;
                    for (int i = 0; i < list.size(); i++) {
                        sum += list.get(i);
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    printNumbersByOperand(list, command[1], command[2]);
                    break;
            }

            input = scanner.nextLine();
        }

    }

    private static void printNumbersByOperand(List<Integer> input, String operand, String filter) {

        for (int index: input) {
            switch (operand) {
                case ">":
                    if (index > Integer.parseInt(filter)) {
                        System.out.print(index + " ");
                    }
                    break;
                case "<":
                    if (index < Integer.parseInt(filter)) {
                        System.out.print(index + " ");
                    }
                    break;
                case ">=":
                    if (index >= Integer.parseInt(filter)) {
                        System.out.print(index + " ");
                    }
                    break;
                case "<=":
                    if (index <= Integer.parseInt(filter)) {
                        System.out.print(index + " ");
                    }
                    break;
            }
        }

        System.out.println();
    }

    static void printEvenOrOddNumbers (List<Integer> input, String evenOrOdd) {

        for (int index: input) {

            if (index % 2 == 0 && evenOrOdd.equals("even") ||
                    (index % 2 == 1 && evenOrOdd.equals("odd"))) {
                System.out.print(index + " ");
            }
        }

        System.out.println();
    }
}
