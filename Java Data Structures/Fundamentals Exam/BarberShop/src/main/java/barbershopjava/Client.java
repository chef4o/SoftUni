package barbershopjava;

import java.util.Objects;

public class Client {

    public String name;
    public int age;
    public Gender gender;
    public Barber barber;

    public Client(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public int getBarberStars() {
        return this.barber.getStars();
    }

    public Barber getBarber() {
        return barber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
