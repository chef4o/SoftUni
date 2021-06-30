package inheritanceEx.needForSpeed;

public class Main {
    public static void main(String[] args) {

        Car car = new Car(30, 50);
        car.drive(10);
        System.out.println(car.getFuel());
    }
}
