package Methods;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println(subtract(sum(a, b), c));
    }
    static int sum(int x, int y) {
        return x + y;
    }
    static int subtract(int x, int y) {
        return x - y;
    }
}
