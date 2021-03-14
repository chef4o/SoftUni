package Lists;

import java.util.*;
import java.util.stream.Collectors;

public class ListManipulationBasic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list =
                Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            String[] array = input.split(" ");

            switch (array[0]) {
                case "Add":
                    list.add(Integer.parseInt(array[1]));
                    break;
                case "Remove":
                    list.remove(Integer.valueOf(array[1]));
                    break;
                case "RemoveAt":
                    list.remove(Integer.parseInt(array[1]));
                    break;
                case "Insert":
                    list.add(Integer.parseInt(array[2]), Integer.parseInt(array[1]));
                    break;
            }

            input = scanner.nextLine();
        }

        for (int index: list) {
            System.out.print(index + " ");
        }
    }
}
