package SetsAndMaps;

import java.util.*;
public class AverageStudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        TreeMap<String, List<Double>> studentsDatabase = new TreeMap<>()    ;

        while (numberOfStudents-- > 0) {

            String[] currentStudent = scanner.nextLine().split("\\s+");
            String studentName = currentStudent[0];
            double studentGrade = Double.parseDouble(currentStudent[1]);

            studentsDatabase.putIfAbsent(studentName, new ArrayList<>());
            studentsDatabase.get(studentName).add(studentGrade);
        }


        for (Map.Entry<String, List<Double>> student : studentsDatabase.entrySet()) {

            String name = student.getKey();
            System.out.printf("%s -> ", name);

            for (Double grade : student.getValue()) {
                System.out.printf("%.2f ", grade);
            }

            Double averageScore = student.getValue()
                    .stream().mapToDouble(Double::valueOf).average().orElse(0.0);

            System.out.printf("(avg: %.2f)\n", averageScore);
        }
    }
}
