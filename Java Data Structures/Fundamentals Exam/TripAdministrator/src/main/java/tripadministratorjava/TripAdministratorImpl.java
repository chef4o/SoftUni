package tripadministratorjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TripAdministratorImpl implements TripAdministrator {

    List<Company> companies;
    List<Trip> trips;

    public TripAdministratorImpl() {
        this.companies = new ArrayList<>();
        this.trips = new ArrayList<>();
    }

    @Override
    public void addCompany(Company c) {
        validate(!exist(c));
        this.companies.add(c);
    }

    @Override
    public void addTrip(Company c, Trip t) {
        validate(exist(c)
                && c.getTrips().size() < c.tripOrganizationLimit
                && !c.getTrips().contains(t));
        this.trips.add(t);
        c.getTrips().add(t);
    }

    @Override
    public boolean exist(Company c) {
        return this.companies.stream()
                .anyMatch(company -> company.equals(c));
    }

    @Override
    public boolean exist(Trip t) {
        return this.trips.stream()
                .anyMatch(trip -> trip.equals(t));
    }

    @Override
    public void removeCompany(Company c) {
        validate(exist(c));
        this.trips.removeAll(c.getTrips());
        this.companies.remove(c);
    }

    @Override
    public Collection<Company> getCompanies() {
        return this.companies;
    }

    @Override
    public Collection<Trip> getTrips() {
        return this.trips;
    }

    @Override
    public void executeTrip(Company c, Trip t) {
        validate(exist(c)
                && exist(t)
                && c.getTrips().contains(t));
        c.getTrips().remove(t);
        this.trips.remove(t);
    }

    @Override
    public Collection<Company> getCompaniesWithMoreThatNTrips(int n) {
        validate(n >= 0);
        return this.companies.stream()
                .filter(c -> c.getTrips().size() > n)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Trip> getTripsWithTransportationType(Transportation t) {
        validate(Arrays.asList(Transportation.values()).contains(t));
        return this.trips.stream()
                .filter(trip -> trip.transportation.equals(t))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Trip> getAllTripsInPriceRange(int lo, int hi) {
        validate(lo >= 0 && hi >= 0);
        return this.trips.stream()
                .filter(trip -> trip.price >= lo && trip.price <= hi)
                .collect(Collectors.toList());
    }

    private void validate(Boolean isTrue) {
        if (!isTrue) {
            throw new IllegalArgumentException();
        }
    }
}
