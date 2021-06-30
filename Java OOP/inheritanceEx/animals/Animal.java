package inheritanceEx.animals;

public abstract class Animal {

    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    private void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    public void setGender(String gender) {
        if (gender == null || gender.isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    public String produceSound() {
        return "";
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(getClass().getSimpleName()).append(System.lineSeparator());
        output.append(String.format("%s %d %s", this.name, this.age, this.gender)).append(System.lineSeparator());
        output.append(produceSound());
        return output.toString();
    }
}
