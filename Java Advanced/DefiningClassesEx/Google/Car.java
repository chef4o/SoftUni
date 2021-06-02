package DefiningClassesEx.Google;

public class Car {

    String carModel;
    int carSpeed;

    public Car(String carModel, int carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    public Car() {

    }

    @Override
    public String toString() {

        StringBuilder output = new StringBuilder("Car:").append(System.lineSeparator());
        if (carModel != null) {
            output.append(carModel).append(" ").append(carSpeed).append(System.lineSeparator());
        }
        return output.toString();
    }
}
