package SetsAndMapsEx;

import java.util.*;

public class SetsOfElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] setsSizes = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Set<Integer> setOne = FillSet(scanner, setsSizes[0]);
        Set<Integer> setTwo = FillSet(scanner, setsSizes[1]);
        List<Integer> output = FillList(setOne, setTwo);

        output.forEach(e -> System.out.printf("%s ", e));
    }

    public static Set<Integer> FillSet(Scanner scanner, int setSize) {

        Set<Integer> set = new LinkedHashSet<>();
        while (setSize-- > 0) {
            set.add(scanner.nextInt());
        }

        return set;
    }

    public static List<Integer> FillList(Set<Integer> setOne, Set<Integer> setTwo) {

        List<Integer> output = new ArrayList<>();

        for (Integer entry : setOne) {
            if (setTwo.contains(entry)) {
                output.add(entry);
            }
        }

        return output;
    }
}
