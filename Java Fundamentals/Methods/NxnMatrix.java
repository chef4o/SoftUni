package Methods;

import java.util.Scanner;

public class NxnMatrix {
    public static void main(String[] args) {
        int input = new Scanner(System.in).nextInt();

        nxnMatrixPrint(input);
    }

    static void nxnMatrixPrint(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                System.out.printf("%d ", x);
            }
            System.out.println();
        }
    }
}
