package BasicSyntaxEx;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        double saberPrice = Double.parseDouble(scanner.nextLine());
        double robePrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());

        double fundsNeeded = studentsCount * (robePrice) +
                Math.ceil(studentsCount * (1 + 10 / 100d)) * saberPrice +
                studentsCount * beltPrice - Math.floor(studentsCount / 6d) * beltPrice;

        if (fundsNeeded <= budget) {
            System.out.printf("The money is enough - it would cost %.2flv.", fundsNeeded);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.", fundsNeeded - budget);
        }
    }
}
