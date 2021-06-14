package StacksAndQueuesEx;

import java.util.*;

public class Robotic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(";");

        String[] robotNames = new String[input.length];
        int[] robotPerformance = new int[input.length];
        int[] robotTimers = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            String[] robotDetails = input[i].split("-");
            robotNames[i] = robotDetails[0];
            robotPerformance[i] = Integer.parseInt(robotDetails[1]);
        }

        int[] startingPoint = Arrays.stream(scanner.nextLine()
                .split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();
        long startTimer = startingPoint[0] * 3600 + startingPoint[1] * 60 + startingPoint[2];

        ArrayDeque<String> productLine = new ArrayDeque<>();
        String product;
        while (!"End".equals(product = scanner.nextLine())) {

            productLine.offer(product);
        }

        while (!productLine.isEmpty()) {

            startTimer++;
            String item  = productLine.poll();
            int availableRobot = -1;

            for (int i = 0; i < robotTimers.length; i++) {
                if (robotTimers[i] > 0) {
                    robotTimers[i]--;
                }

                if (robotTimers[i] == 0 && availableRobot == -1) {
                    availableRobot = i;
                }
            }

            if (availableRobot != -1) {
                robotTimers[availableRobot] = robotPerformance[availableRobot];
                System.out.printf("%s - %s [%s]\n",robotNames[availableRobot], item, timeConvertor(startTimer));
            } else {
                productLine.offer(item);
            }
        }
    }

    private static String timeConvertor(long timeInSeconds) {

        long seconds = timeInSeconds % 60;
        long minutes = (timeInSeconds / 60) % 60;
        long hours = (timeInSeconds / (60 * 60)) % 24;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}