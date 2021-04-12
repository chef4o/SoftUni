package Exam;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder output = new StringBuilder(input);

        String[] command = scanner.nextLine().split(" ");
        while (!input.contains("Done")) {


            switch (command[0]) {
                case "Change":
                    char charToReplace = command[1].charAt(0);
                    char newChar = command[2].charAt(0);

                    output = new StringBuilder(output.toString().replaceAll(String.valueOf(charToReplace),String.valueOf(newChar)));
                    System.out.println(output);
                    break;
                case "Includes":
                    String checkWord = command[1];

                    if (output.toString().contains(checkWord)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "End":
                    String suffix = command[1];

                    if (output.toString().endsWith(suffix)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Uppercase":
                    System.out.println(output.toString().toUpperCase());
                    break;
                case "FindIndex":
                    char checkIndex = command[1].charAt(0);

                    System.out.println(input.indexOf(checkIndex));
                    break;
                case "Cut":
                    int firstIndex = Integer.parseInt(command[1]);
                    int length = Integer.parseInt(command[2]);

                    output = new StringBuilder(output.toString().substring(firstIndex, firstIndex + length));
                    System.out.println(output);
                    break;
            }

            input = scanner.nextLine();
            command = input.split(" ");
        }
    }
}
