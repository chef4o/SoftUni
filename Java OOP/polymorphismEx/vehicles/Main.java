package polymorphismEx.vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carData = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carData[1]), Double.parseDouble(carData[2]));
        String[] truckData = scanner.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckData[1]), Double.parseDouble(truckData[2]));

        int input = Integer.parseInt(scanner.nextLine());
        while (input-- > 0) {
            String[] command = scanner.nextLine().split("\\s+");
            String vehicle = command[1];
            switch (command[0]) {
                case "Drive":
                    double distance = Double.parseDouble(command[2]);
                    switch (vehicle) {
                        case "Car":
                            car.driving(distance);
                            break;
                        case "Truck":
                            truck.driving(distance);
                            break;
                    }
                    break;
                case "Refuel":
                    double liters = Double.parseDouble(command[2]);
                    switch (vehicle) {
                        case "Car":
                            car.refuel(liters);
                            break;
                        case "Truck":
                            truck.refuel(liters);
                            break;
                    }
                    break;
            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
    }
}
