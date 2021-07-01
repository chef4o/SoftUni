package interfacesAndAbstractions.borderControl;

public class Citizen extends Subject implements Identifiable {

    private int age;

    public Citizen(String name, int age, String id) {
        super(name, id);
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String getId() {
        return super.getId();

    }

    public String getName() {
        return super.getIdentifier();
    }
}
