package DefiningClassesEx.Google;

public class Person {

    String name;
    Company company = new Company();
    Pokemon pokemon = new Pokemon();
    Parents parents = new Parents();
    Children children = new Children();
    Car car = new Car();

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Company company) {
        this.name = name;
        this.company = company;
    }

    public Person(String name, Pokemon pokemon) {
        this.name = name;
        this.pokemon = pokemon;
    }

    public Person(String name, Parents parents) {
        this.name = name;
        this.parents = parents;
    }

    public Person(String name, Children children) {
        this.name = name;
        this.children = children;
    }

    public Person(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(name).append(System.lineSeparator())
              .append(company).append(car)
              .append(pokemon).append(parents)
              .append(children);
        return output.toString();
    }
}
