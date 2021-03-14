package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputA = scanner.nextLine().split(" ");
        String[] inputB = scanner.nextLine().split(" ");

        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < Math.max(inputA.length, inputB.length); i++) {

            while (i < Math.min(inputA.length, inputB.length)) {
                output.add(Integer.parseInt(inputA[i]));
                output.add(Integer.parseInt(inputB[i++]));
            }

            if (inputA.length > inputB.length) {
                output.add(Integer.parseInt(inputA[i]));
            } else if (inputA.length < inputB.length) {
                output.add(Integer.parseInt(inputB[i]));
            }

        }

        for (int num: output) {
            System.out.print(num + " ");
        }
    }
}
