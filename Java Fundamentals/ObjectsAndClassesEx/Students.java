package ObjectsAndClassesEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {

    static class Student {
        String firstName;
        String lastName;
        double grade;

        public Student(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public String toString() {
            return String.format("%s %s: %.2f", this.firstName, this.lastName, this.grade);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int entries = Integer.parseInt(scanner.nextLine());
        List<Student> studentDatabase = new ArrayList<>();

        for (int i = 0; i < entries; i++) {
            String[] input = scanner.nextLine().split(" ");
            Student newStudent = new Student(input[0], input[1], Double.parseDouble(input[2]));
            studentDatabase.add(newStudent);
        }

        studentDatabase.stream()
                .sorted((s1, s2) -> Double.compare(s2.grade, s1.grade))
                .forEach(student -> System.out.println(student.toString()));
    }
}
