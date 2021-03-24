package ListsEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bomb2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> area = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> bombInfo = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int bombType = bombInfo.get(0);
        int bombPower = bombInfo.get(1);

        while (area.contains(bombType)) {

            int bombPosition = area.indexOf(bombType);

            int leftWave = Math.max(0, bombPosition - bombPower);
            int rightWave = Math.min(area.size() - 1, bombPosition + bombPower);

            for (int i = rightWave; i >= leftWave; i--) {
                area.remove(i);
            }
        }

        int sum = 0;
        for (Integer element: area) {
            sum += element;
        }

        System.out.println(sum);
    }
}
