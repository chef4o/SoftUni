package DefiningClassesEx.Google;

public class Company {

    String companyName;
    String department;
    double salary;

    public Company(String companyName, String department, double salary) {
        this.companyName = companyName;
        this.department = department;
        this.salary = salary;
    }

    public Company() {

    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("Company:").append(System.lineSeparator());
        if (companyName != null) {
            output.append(companyName).append(" ")
                    .append(department).append(" ")
                    .append(String.format("%.2f", salary)).append(System.lineSeparator());
        }
        return output.toString();
    }
}
