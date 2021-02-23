package BasicSyntax;

import com.sun.tools.jconsole.JConsoleContext;

import java.util.Scanner;

public class SumOfOddNums {
    public static void main(String[] args) {
        int input = new Scanner(System.in).nextInt();

        int sum = 0;
        int num = 1;
        for (int i = 0; i < input; i++) {
            System.out.println(num);
            sum += num;
            num += 2;
        }

        System.out.printf("Sum: %d", sum);
    }
}
