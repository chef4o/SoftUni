package barbershopjava;

import java.util.*;
import java.util.stream.Collectors;

public class BarberShopImpl implements BarberShop {

    List<Barber> barbers;
    List<Client> clients;

    public BarberShopImpl() {
        this.barbers = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    @Override
    public void addBarber(Barber b) {
        validate(!exist(b));
        this.barbers.add(b);
    }

    @Override
    public void addClient(Client c) {
        validate(!exist(c));
        this.clients.add(c);
    }

    @Override
    public boolean exist(Barber b) {
        return this.barbers.stream()
                .anyMatch(bar -> bar.equals(b));
    }

    @Override
    public boolean exist(Client c) {
        return this.clients.stream()
                .anyMatch(client -> client.equals(c));
    }

    @Override
    public Collection<Barber> getBarbers() {
        return this.barbers;
    }

    @Override
    public Collection<Client> getClients() {
        return this.clients;
    }

    @Override
    public void assignClient(Barber b, Client c) {
        validate(exist(b) && exist(c)
                && !b.contains(c));
        c.barber = b;
        b.addClient(c);
    }

    @Override
    public void deleteAllClientsFrom(Barber b) {
        validate(this.exist(b));
        for (Client client : this.clients) {
            if (client.barber.equals(b)) {
                client.barber = null;
            }
        }
        b.removeAllClients();
    }

    @Override
    public Collection<Client> getClientsWithNoBarber() {
        return this.clients.stream()
                .filter(c -> c.barber == null)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Barber> getAllBarbersSortedWithClientsCountDesc() {
        return this.barbers.stream()
                .sorted(Comparator.comparing(Barber::getClientsCount).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Barber> getAllBarbersSortedWithStarsDescendingAndHaircutPriceAsc() {
        Comparator<Barber> byStarsDesc = Comparator.comparing(Barber::getStars).reversed();
        Comparator<Barber> byPriceAsc = Comparator.comparing(Barber::getHaircutPrice);

        return this.barbers.stream()
                .sorted(byStarsDesc.thenComparing(byPriceAsc))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Client> getClientsSortedByAgeDescAndBarbersStarsDesc() {
        Comparator<Client> byAgeDesc = Comparator.comparing(Client::getAge).reversed();
        Comparator<Client> byBarberStarsDesc = Comparator.comparing(Client::getBarberStars).reversed();

        return this.clients.stream()
                .filter(c -> c.getBarber() != null)
                .sorted(byAgeDesc.thenComparing(byBarberStarsDesc))
                .collect(Collectors.toList());
    }

    private void validate(Boolean isTrue) {
        if (!isTrue) {
            throw new IllegalArgumentException();
        }
    }
}
