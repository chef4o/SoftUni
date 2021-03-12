package ObjectsAndClasses;

import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorial {
    public static void main(String[] args) {
        short input = new Scanner(System.in).nextShort();

        BigInteger factorial = new BigInteger("1");

        for (int i = 1; i <= input; i++) {

            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        System.out.println(factorial);
    }
}
