package DefiningClassesEx.RawData;

import java.util.ArrayList;
import java.util.List;

public class Tire {

    String model;
    int tire1Age;
    double tire1Pressure;
    int tire2Age;
    double tire2Pressure;
    int tire3Age;
    double tire3Pressure;
    int tire4Age;
    double tire4Pressure;
    List<Double> tirePressure = new ArrayList<>();

    public Tire(String model,
                int tire1Age, double tire1Pressure,
                int tire2Age, double tire2Pressure,
                int tire3Age, double tire3Pressure,
                int tire4Age, double tire4Pressure) {

        this.model = model;
        this.tire1Age = tire1Age;
        this.tire1Pressure = tire1Pressure;
        tirePressure.add(this.tire1Pressure);

        this.tire2Age = tire2Age;
        this.tire2Pressure = tire2Pressure;
        tirePressure.add(this.tire2Pressure);

        this.tire3Age = tire3Age;
        this.tire3Pressure = tire3Pressure;
        tirePressure.add(this.tire3Pressure);

        this.tire4Age = tire4Age;
        this.tire4Pressure = tire4Pressure;
        tirePressure.add(this.tire4Pressure);
    }

    public boolean hasSoftTire () {

        for (Double tire : tirePressure) {
            if (tire < 1) {
                return true;
            }
        }

        return false;
    }
}
