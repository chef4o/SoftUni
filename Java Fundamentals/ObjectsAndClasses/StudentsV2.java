package ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentsV2 {

    static class Students {
        String firstName;
        String lastName;
        int age;
        String homeTown;

        public Students(String firstName, String lastName, int age, String homeTown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.homeTown = homeTown;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public int getAge() {
            return this.age;
        }

        public String getHomeTown() {
            return homeTown;
        }

        public Students setAge(int age) {
            this.age = age;
            return this;
        }

        public Students setHomeTown(String homeTown) {
            this.homeTown = homeTown;
            return this;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        List<Students> allStudents = new ArrayList<>();

        while (!input[0].equals("end")) {

            Students currentStudent = new Students(input[0], input[1], Integer.parseInt(input[2]), input[3]);

            int existingIndex = matchingStudentIndex(allStudents, currentStudent.firstName, currentStudent.lastName);
            if (existingIndex != -1) {
                allStudents.get(existingIndex).setAge(currentStudent.age);
                allStudents.get(existingIndex).setHomeTown(currentStudent.homeTown);
            } else {
                allStudents.add(currentStudent);
            }

            input = scanner.nextLine().split(" ");
        }

        String filter = scanner.nextLine();

        for (Students student : allStudents) {
            if (student.getHomeTown().equals(filter)) {
                System.out.printf("%s %s is %d years old\n",
                        student.firstName,
                        student.lastName,
                        student.age);
            }
        }
    }

    static int matchingStudentIndex(List<Students> students, String firstName, String lastName) {

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getFirstName().equals(firstName)
                    && students.get(i).getLastName().equals(lastName)) {
                return i;
            }
        }

        return -1;
    }
}
