package Methods;

import java.util.Scanner;

public class SmallestOfThreeNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println(SmallestNum(a, b, c));
    }

    static int SmallestNum(int x, int y, int z) {

        int smallestNum;

        if ((x + y) / 2 > z) {
            smallestNum = z;
        } else if ((x + z) / 2 > y) {
            smallestNum = y;
        } else {
            smallestNum = x;
        }

        return  smallestNum;
    }

}
