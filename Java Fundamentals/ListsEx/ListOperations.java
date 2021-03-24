package ListsEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.next();
        while (!command.equals("End")) {

            switch (command) {
                case "Add":
                    input.add(Integer.parseInt(scanner.next()));
                    break;
                case "Insert":
                    int number = Integer.parseInt(scanner.next());
                    int indexToInsert = Integer.parseInt(scanner.next());

                    if (wrongIndexError(input, indexToInsert)) {
                        System.out.println("Invalid index");
                    } else {
                        input.add(indexToInsert, number);
                    }
                    break;
                case "Remove":
                    int indexToDelete = Integer.parseInt(scanner.next());

                    if (wrongIndexError(input, indexToDelete)) {
                        System.out.println("Invalid index");
                    } else {
                        input.remove(indexToDelete);
                    }
                    break;
                case "Shift":
                    String direction = scanner.next();
                    int turns = Integer.parseInt(scanner.next());
                    moveNumbers(input, direction, turns);
                    break;
            }

            command = scanner.next();
        }

        System.out.println(input.toString().replaceAll("[\\[\\],]", ""));
    }

    static void moveNumbers (List<Integer> input, String direction, int turns) {

            for (int i = 0; i < turns; i++) {

                if (direction.equals("left")) {
                input.add(input.get(0));
                input.remove(0);
                } else {
                    input.add(0, input.get(input.size()-1));
                    input.remove(input.size()-1);
                }
            }
    }

    static boolean wrongIndexError(List<Integer> list, int index) {
        if (index < 0 || index > list.size() - 1) {
            return true;
        } else {
            return false;
        }
    }
}
