package ObjectsAndClassesEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VehicleCatalogue {

    static class Vehicle {
        String type;
        String model;
        String color;
        int horsepower;

        public Vehicle(String type, String model, String color, int horsepower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }

        public String getType() {
            return this.type;
        }

        public String getModel() {
            return this.model;
        }

        public String getColor() {
            return this.color;
        }

        public int getHorsepower() {
            return this.horsepower;
        }

        public void printVehicleData() {

            String Type = Character.toUpperCase(getType().charAt(0)) + getType().substring(1);

            System.out.printf("Type: %s\nModel: %s\nColor: %s\nHorsepower: %d\n",
                    Type, getModel(), getColor(), getHorsepower());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> vehicleDatabase = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] newEntry = input.split(" ");
            Vehicle newVehicle = new Vehicle(newEntry[0], newEntry[1], newEntry[2], Integer.parseInt(newEntry[3]));
            vehicleDatabase.add(newVehicle);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("Close the Catalogue")) {

            String model = input;

            vehicleDatabase.stream()
                    .filter(vehicle -> vehicle.getModel().equals(model))
                    .forEach(Vehicle::printVehicleData);

            input = scanner.nextLine();
        }

        List<Vehicle> allCars = vehicleDatabase.stream()
                .filter(vehicle -> vehicle.getType().equals("car"))
                .collect(Collectors.toList());

        List<Vehicle> allTrucks = vehicleDatabase.stream()
                .filter(vehicle -> vehicle.getType().equals("truck"))
                .collect(Collectors.toList());

        System.out.printf("Cars have average horsepower of: %.2f.\nTrucks have average horsepower of: %.2f.",
                averageHorsepowers(allCars), averageHorsepowers(allTrucks));
    }

    static double averageHorsepowers(List<Vehicle> vehicles) {

        if (vehicles.size() == 0) {
            return 0d;
        } else {
            return vehicles.stream()
                    .mapToDouble(Vehicle::getHorsepower)
                    .sum() / vehicles.size();
        }
    }
}