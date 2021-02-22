package ForLoopsEx;

import java.util.Scanner;

public class DivisionWithoutRemain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        int divisionByTwo = 0;
        int divisionByThree = 0;
        int divisionByFour = 0;

        for (int i = 0; i < input; i++) {

            int number = scanner.nextInt();
            if (number % 2 == 0) {
                divisionByTwo++;
            }
            if (number % 3 == 0) {
                divisionByThree++;
            }
            if (number % 4 == 0) {
                divisionByFour++;
            }
        }

        double groupOne = 100d * divisionByTwo / input;
        double groupTwo = 100d * divisionByThree / input;
        double groupThree = 100d * divisionByFour / input;

        System.out.printf("%.2f%%\n%.2f%%\n%.2f%%", groupOne, groupTwo, groupThree);

    }
}
