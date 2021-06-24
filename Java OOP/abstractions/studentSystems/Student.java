package abstractions.studentSystems;

public class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double getGrade() {
        return this.grade;
    }

    public String getStudentInfo() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%s is %s years old. ", getName(), getAge()));
        if (getGrade() >= 5.00) {
            output.append("Excellent student.");
        } else if (getGrade() < 5.00 && getGrade() >= 3.50) {
            output.append("Average student.");
        } else {
            output.append("Very nice person.");
        }
        return output.toString();
    }
}
