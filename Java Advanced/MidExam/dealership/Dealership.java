package dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private List<Car> data;
    public String name;
    public int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList();
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }

    }

    public boolean buy(String manufacturer, String model) {
        for(int i = 0; i < this.data.size(); ++i) {
            if (((Car)this.data.get(i)).getManufacturer().equals(manufacturer)
                    && ((Car)this.data.get(i)).getModel().equals(model)) {
                this.data.remove(this.data.get(i));
                return true;
            }
        }

        return false;
    }

    public Car getLatestCar() {

        return !this.data.isEmpty()
                ? (Car)this.data.stream().max((a, b) -> {
            return Integer.compare(a.getYear(), b.getYear());
        }).orElse(null)
                : null;
    }

    public Car getCar(String manufacturer, String model) {
        for(int i = 0; i < this.data.size(); ++i) {
            if (((Car)this.data.get(i)).getManufacturer().equals(manufacturer)
                    && ((Car)this.data.get(i)).getModel().equals(model)) {
                return (Car)this.data.get(i);
            }
        }

        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder stats = new StringBuilder();
        stats.append(String.format("The cars are in a car dealership %s:", this.name));
        stats.append(System.lineSeparator());
        this.data.forEach((car) -> {
            stats.append(String.format("%s%s", car.toString(), System.lineSeparator()));
        });
        return stats.toString();
    }
}
