package abstractions.pointsInRectangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] bottomLeftValues = new int[] {scanner.nextInt(), scanner.nextInt()};
        int[] upperRightValues = new int[] {scanner.nextInt(), scanner.nextInt()};

        Rectangle rectangle = new Rectangle(bottomLeftValues, upperRightValues);

        int checks = scanner.nextInt();
        while (checks-- > 0) {
            System.out.println(rectangle.contains
                    (new Point(scanner.nextInt(), scanner.nextInt())));
        }
    }
}
