package polymorphismEx.vehiclesExtended;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Vehicle car = setVehicle(scanner.nextLine());
        Vehicle truck = setVehicle(scanner.nextLine());
        Vehicle bus = setVehicle(scanner.nextLine());

        int input = Integer.parseInt(scanner.nextLine());
        while (input-- > 0) {
            String[] command = scanner.nextLine().split("\\s+");
            String vehicle = command[1];
            try {
                switch (command[0]) {
                    case "Drive": {
                        double distance = Double.parseDouble(command[2]);
                        if ("Car".equals(vehicle)) {
                            car.driving(distance);
                        } else if ("Truck".equals(vehicle)) {
                            truck.driving(distance);
                        } else if ("Bus".equals(vehicle)) {
                            bus.driving(distance);
                        }
                        break;
                    }
                    case "DriveEmpty": {
                        double distance;
                        distance = Double.parseDouble(command[2]);
                        bus.driveEmpty(distance);
                        break;
                    }
                    case "Refuel":
                        double liters = Double.parseDouble(command[2]);
                        if ("Car".equals(vehicle)) {
                            car.refuel(liters);
                        } else if ("Truck".equals(vehicle)) {
                            truck.refuel(liters);
                        } else if ("Bus".equals(vehicle)) {
                            bus.refuel(liters);
                        }
                        break;
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }

    public static Vehicle setVehicle(String input) {
        String[] vehicleData = input.split("\\s+");
        String vehicle = vehicleData[0];
        double initialFuel = Double.parseDouble(vehicleData[1]);
        double consumption = Double.parseDouble(vehicleData[2]);
        double tankCapacity = Double.parseDouble(vehicleData[3]);

        switch (vehicle) {
            case "Car":
                return new Car(initialFuel, consumption, tankCapacity);
            case "Truck":
                return new Truck(initialFuel, consumption, tankCapacity);
            case "Bus":
                return new Bus(initialFuel, consumption, tankCapacity);
            default:
                return new Vehicle(initialFuel, consumption, tankCapacity);
        }
    }
}
