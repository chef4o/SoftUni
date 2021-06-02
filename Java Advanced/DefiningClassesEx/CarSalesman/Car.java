package DefiningClassesEx.CarSalesman;

public class Car {

    String model;
    Engine engine;
    int weight;
    String color;

    public Car (String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, 0, color);
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, "n/a");
    }

    public Car(String model, Engine engine) {
        this(model, engine, 0, "n/a");
    }

    @Override
    public String toString() {

        StringBuilder output = new StringBuilder();
        output.append(this.model); output.append(':');
        output.append(System.lineSeparator());
        output.append(this.engine.toString());
        output.append(System.lineSeparator());
        output.append("Weight: "); output.append(this.weight == 0 ? "n/a" : this.weight);
        output.append(System.lineSeparator());
        output.append("Color: "); output.append(this.color);
        output.append(System.lineSeparator());

         return output.toString().trim();
    }
}