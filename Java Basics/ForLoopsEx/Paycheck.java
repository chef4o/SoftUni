package ForLoopsEx;

import java.util.Scanner;

public class Paycheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int salary = Integer.parseInt(scanner.nextLine());

        while (salary > 0 && n > 0) {
            String tabName = scanner.nextLine();

            switch (tabName) {
                case "Facebook":
                    salary -= 150;
                    break;
                case "Instagram":
                    salary -= 100;
                    break;
                case "Reddit":
                    salary -= 50;
                    break;
            }

            n--;
        }

        if (salary <= 0) {
            System.out.println("You have lost your salary.");
        }
        else {
            System.out.println(salary);
        }
    }
}
