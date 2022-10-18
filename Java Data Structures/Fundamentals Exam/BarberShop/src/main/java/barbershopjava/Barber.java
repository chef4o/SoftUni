package barbershopjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Barber {

    public String name;
    public int haircutPrice;
    public int stars;
    private List<Client> assignedClients;

    public Barber(String name, int haircutPrice, int stars) {
        this.name = name;
        this.haircutPrice = haircutPrice;
        this.stars = stars;
        this.assignedClients = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getClientsCount() {
        return this.assignedClients.size();
    }

    public void addClient(Client c) {
        this.assignedClients.add(c);
    }

    public void removeClient(Client c) {
        this.assignedClients.remove(c);
    }

    public void removeAllClients() {
        this.assignedClients.clear();
    }

    public boolean contains(Client c) {
        return this.assignedClients.contains(c);
    }

    public int getStars() {
        return this.stars;
    }

    public int getHaircutPrice() {
        return this.haircutPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Barber barber = (Barber) o;
        return Objects.equals(name, barber.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
