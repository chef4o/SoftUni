package university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.setCapacity(capacity);
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (this.getStudents().contains(student)) {
            return "Student is already in the university";
        } else if (this.getStudentCount() >= capacity) {
            return "No seats in the university";
        }

        this.students.add(student);
        return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
    }

    public String dismissStudent(Student student) {
/*        if (this.getStudents().isEmpty()) {
            return "No students enrolled for the subject";
        }*/
        if (!this.getStudents().contains(student)) {
            return "Student not found";
        }

        this.getStudents().remove(student);
        return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
    }

    public Student getStudent(String firstName, String lastName) {

        for (Student student : this.students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Student student : this.students) {
            sb.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s",
                    student.getFirstName(), student.getLastName(), student.getBestSubject())).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
