package ListsEx;

import java.util.*;
import java.util.stream.Collectors;

public class Trains {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> passengersDistributionByWagon = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxWagonCapacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("end")) {

                String[] newData = input.split(" ");
                if (newData[0].equals("Add")) {
                    passengersDistributionByWagon.add(Integer.parseInt(newData[1]));
                } else {
                    for (int i = 0; i < passengersDistributionByWagon.size(); i++) {

                        int newOccupation = passengersDistributionByWagon.get(i) + Integer.parseInt(newData[0]);

                        if (newOccupation <= maxWagonCapacity) {
                            passengersDistributionByWagon.set(i, newOccupation);
                            break;
                        }
                    }
                }

                input = scanner.nextLine();
        }

        System.out.println(passengersDistributionByWagon.toString().replaceAll("[\\[\\],]", ""));
    }
}
