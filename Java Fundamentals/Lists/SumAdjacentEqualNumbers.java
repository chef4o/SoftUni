package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        List<Double> list = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            list.add(Double.parseDouble(input[i]));
        }

        int i = 0;
        while (i < list.size() - 1) {
            if (list.get(i).equals(list.get(i + 1))) {
                list.set(i, list.get(i) + list.get(i + 1));
                list.remove(i + 1);
                i = 0;
            } else {
                i++;
            }
        }

        for (int j = 0; j < list.size(); j++) {
            if (list.get(j) % 1 == 0) {
                System.out.printf("%.0f ", list.get(j));
            } else {
             System.out.print(list.get(j) + " ");
            }
        }
    }
}
