package FirstStepsInCoding;

import java.util.Scanner;

public class ProjectCreation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();
        int projectsCount = Integer.parseInt(scan.nextLine());

        int hoursNeeded = projectsCount * 3;

        System.out.printf("The architect %s will need %d hours to complete %d project/s.", name, hoursNeeded, projectsCount);
    }
}
