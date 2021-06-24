package abstractions.studentSystems;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem database = new StudentSystem();

        String input;
        while (!(input = scanner.nextLine()).equals("Exit")) {
            String[] entryData = input.split("\\s+");
            String command = entryData[0];
            String name = entryData[1];
            switch (command) {
                case "Create":
                    int age = Integer.parseInt(entryData[2]);
                    double grade = Double.parseDouble(entryData[3]);
                    database.createStudent(new Student(name, age, grade));
                    break;
                case "Show":
                    if (database.getDatabase().containsKey(name)) {
                        database.printEntry(name);
                    }
                    break;
            }
        }
    }
}