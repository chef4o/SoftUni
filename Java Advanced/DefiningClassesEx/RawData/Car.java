package DefiningClassesEx.RawData;

public class Car {

    String model;
    Engine engine;
    Tire tires;
    Cargo cargo;

    public Car (String model, Engine engine, Cargo cargo, Tire tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }
}
