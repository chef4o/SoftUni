package abstractions.studentSystems;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> database;

    public StudentSystem() {
        this.database = new HashMap<>();
    }

    public void createStudent(Student student) {
        if (!database.containsKey(student.getName())) {
            database.put(student.getName(), student);
        }
    }

    public Map<String, Student> getDatabase() {
        return database;
    }

    public void printEntry(String name) {
        System.out.println(database.get(name).getStudentInfo());
    }
}
