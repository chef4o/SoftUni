package tripadministratorjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Company {

    public String name;
    public int tripOrganizationLimit;
    private List<Trip> trips;

    public Company(String name, int tripOrganizationLimit) {
        this.name = name;
        this.tripOrganizationLimit = tripOrganizationLimit;
        this.trips = new ArrayList<>();
    }

    public List<Trip> getTrips() {
        return trips;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
