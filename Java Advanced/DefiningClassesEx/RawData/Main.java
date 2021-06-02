package DefiningClassesEx.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int entries = Integer.parseInt(scanner.nextLine());

        List<Car> carsDatabase = new ArrayList<>();

        while (entries-- > 0) {

            String[] currentVehicle = scanner.nextLine().split("\\s+");

            String currentModel = currentVehicle[0];
            int currentEngineSpeed = Integer.parseInt(currentVehicle[1]);
            int currentEnginePower = Integer.parseInt(currentVehicle[2]);
            Engine currentEngine = new Engine(currentModel, currentEngineSpeed, currentEnginePower);

            int currentCargoWeight = Integer.parseInt(currentVehicle[3]);
            String currentCargoType = currentVehicle[4];
            Cargo currentCargo = new Cargo(currentModel, currentCargoType, currentCargoWeight);

            double tire1Pressure = Double.parseDouble(currentVehicle[5]);
            int tire1Age = Integer.parseInt(currentVehicle[6]);
            double tire2Pressure = Double.parseDouble(currentVehicle[7]);
            int tire2Age = Integer.parseInt(currentVehicle[8]);
            double tire3Pressure = Double.parseDouble(currentVehicle[9]);
            int tire3Age = Integer.parseInt(currentVehicle[10]);
            double tire4Pressure = Double.parseDouble(currentVehicle[11]);
            int tire4Age = Integer.parseInt(currentVehicle[12]);
            Tire currentTires = new Tire(currentModel, tire1Age, tire1Pressure, tire2Age, tire2Pressure,
                    tire3Age, tire3Pressure, tire4Age, tire4Pressure);

            Car currentCar = new Car(currentModel, currentEngine, currentCargo, currentTires);
            carsDatabase.add(currentCar);
        }

        String requestedCargoData = scanner.nextLine();

        switch (requestedCargoData) {
            case "fragile":
                carsDatabase.stream()
                        .filter(c -> c.cargo.cargoType.equals(requestedCargoData))
                        .filter(t -> t.tires.hasSoftTire())
                        .forEach(c -> System.out.printf("%s%s", c.model, System.lineSeparator()));
                break;
            case "flamable":
                carsDatabase.stream()
                        .filter(c -> c.cargo.cargoType.equals(requestedCargoData))
                        .filter(e -> e.engine.enginePower > 250)
                        .forEach(car -> System.out.printf("%s%s", car.model, System.lineSeparator()));
                break;
            default:
                throw new IllegalStateException("Unknown format " + requestedCargoData);
        }
    }
}
