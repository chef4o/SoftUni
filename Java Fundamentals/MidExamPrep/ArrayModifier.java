package MidExamPrep;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] intArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            String[] commandArray = command.split(" ");

            if (commandArray[0].equals("swap")) {
                int swapElement = intArray[Integer.parseInt(commandArray[2])];
                intArray[Integer.parseInt(commandArray[2])] = intArray[Integer.parseInt(commandArray[1])];
                intArray[Integer.parseInt(commandArray[1])] = swapElement;
            } else if (commandArray[0].equals("multiply")) {
                intArray[Integer.parseInt(commandArray[1])] = intArray[Integer.parseInt(commandArray[1])] * intArray[Integer.parseInt(commandArray[2])];
            } else if (commandArray[0].equals("decrease")) {
                for (int i = 0; i < intArray.length; i++) {
                    intArray[i] -= 1;
                }
            }
            command = scanner.nextLine();
        }

        String[] output = new String[intArray.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = String.valueOf(intArray[i]);
        }

        System.out.println(String.join(", ", output));
    }
}