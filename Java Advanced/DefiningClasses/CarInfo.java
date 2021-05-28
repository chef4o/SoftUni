package DefiningClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> carsDatabase = new ArrayList<>();

        int inputs = Integer.parseInt(scanner.nextLine());
        while (inputs-- > 0) {

            String[] carInfo = scanner.nextLine().split("\\s+");
            String brand = carInfo[0];

            Car currentCar;
            if (carInfo.length == 1) {
                currentCar = new Car(brand);
            } else {
                String model = carInfo[1];
                int horsePower = Integer.parseInt(carInfo[2]);
                currentCar = new Car(brand, model, horsePower);
            }

            carsDatabase.add(currentCar);
        }

        for (Car car : carsDatabase) {
            System.out.println(car.toString());
        }
    }
}
