package DefiningClassesEx.CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Engine> enginesDatabase = new LinkedHashMap<>();
        List<Car> carsDatabase = new ArrayList<>();

        int engineTypes = Integer.parseInt(scanner.nextLine());
        while (engineTypes-- > 0) {
            String[] currentEngineData = scanner.nextLine().split("\\s+");
            String engineModel = currentEngineData[0];
            int enginePower = Integer.parseInt(currentEngineData[1]);

            if (currentEngineData.length == 2) {
                enginesDatabase.put(engineModel, new Engine(engineModel, enginePower));
            } else if (currentEngineData.length == 4) {
                int engineDisplacement = Integer.parseInt(currentEngineData[2]);
                String engineEfficiency = currentEngineData[3];
                enginesDatabase.put(engineModel, new Engine(engineModel,
                        enginePower,
                        engineDisplacement,
                        engineEfficiency));
            } else if (currentEngineData.length == 3) {
                if (currentEngineData[2].matches("^\\d+$")) {
                    int engineDisplacement = Integer.parseInt(currentEngineData[2]);
                    enginesDatabase.put(engineModel, new Engine(engineModel,
                            enginePower,
                            engineDisplacement));
                } else {
                    String engineEfficiency = currentEngineData[2];
                    enginesDatabase.put(engineModel, new Engine(engineModel,
                            enginePower,
                            engineEfficiency));
                }
            }
        }

        int carOrders = Integer.parseInt(scanner.nextLine());
        while (carOrders-- > 0) {
            String[] currentCarData = scanner.nextLine().split("\\s+");
            String carModel = currentCarData[0];
            Engine carEngineType = enginesDatabase.get(currentCarData[1]);

            Car currentVehicle = null;
            if (currentCarData.length == 2) {
                currentVehicle = new Car(carModel, carEngineType);
            } else if (currentCarData.length == 4) {
                int weight = Integer.parseInt(currentCarData[2]);
                String color = currentCarData[3];
                currentVehicle = new Car(carModel,
                        carEngineType,
                        weight,
                        color);
            } else if (currentCarData.length == 3) {
                if (currentCarData[2].matches("^\\d+$")) {
                    int weight = Integer.parseInt(currentCarData[2]);
                    currentVehicle = new Car(carModel,
                            carEngineType,
                            weight);
                } else {
                    String color = currentCarData[2];
                    currentVehicle = new Car(carModel,
                            carEngineType,
                            color);
                }
            }

            carsDatabase.add(currentVehicle);
        }

        carsDatabase.forEach(c -> System.out.println(c.toString()));
    }
}
