package abstractionsEx.trafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int cycles = Integer.parseInt(scanner.nextLine());

        List<TrafficLight> trafficLights = new ArrayList<>();

        for (String initialState : input) {
            TrafficLight trafficLight = new TrafficLight(LightColor.valueOf(initialState));
            trafficLights.add(trafficLight);
        }

        while (cycles-- > 0) {
                for (TrafficLight trafficLight : trafficLights) {
                    trafficLight.updateLightColor();
                    System.out.print(trafficLight + " ");
                }
                System.out.println();
        }
    }
}
