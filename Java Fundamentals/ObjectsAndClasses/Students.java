package ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {

    static class Student {
        String firstName;
        String lastName;
        int age;
        String hometown;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        List<Student> allStudents = new ArrayList<>();

        while (!input[0].equals("end")) {

            Student currentInput = new Student();
            currentInput.firstName = input[0];
            currentInput.lastName = input[1];
            currentInput.age = Integer.parseInt(input[2]);
            currentInput.hometown = input[3];
            allStudents.add(currentInput);

            input = scanner.nextLine().split(" ");
        }

        String filter = scanner.nextLine();
        for (int i = 0; i < allStudents.size(); i++) {

            Student check = allStudents.get(i);
            if (filter.equals(check.hometown)) {
                System.out.printf("%s %s is %d years old\n", check.firstName, check.lastName, check.age);
            }
        }
    }
}