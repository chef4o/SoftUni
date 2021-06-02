package DefiningClassesEx.CarSalesman;

public class Engine {

    String model;
    int power;
    int displacement;
    String efficiency;

    public Engine(String engineModel, int power, int displacement, String efficiency) {
        this.model = engineModel;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power, 0, efficiency);
    }

    public Engine(String model, int power, int displacement) {
        this(model, power, displacement, "n/a");
    }

    public Engine(String model, int power) {
        this(model, power, 0, "n/a");
    }

    @Override
    public String toString() {

        StringBuilder output = new StringBuilder();
        output.append(model); output.append(':');
        output.append(System.lineSeparator());
        output.append("Power: "); output.append(power);
        output.append(System.lineSeparator());
        output.append("Displacement: "); output.append(displacement == 0 ? "n/a" : displacement);
        output.append(System.lineSeparator());
        output.append("Efficiency: "); output.append(efficiency);
        output.append(System.lineSeparator());

        return output.toString().trim();
    }
}
