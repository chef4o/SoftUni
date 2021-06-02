package DefiningClassesEx.Google;

import java.util.ArrayList;
import java.util.List;

public class Parents {

    String parentName;
    String parentBirthday;
    List<Parents> family = new ArrayList<>();

    public Parents(String parentName, String parentBirthday) {
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }

    public Parents() {
    }

    @Override
    public String toString() {

        StringBuilder output = new StringBuilder();
        output.append("Parents:\n");
        family.forEach(e -> output.append(String.format("%s %s\n", e.parentName, e.parentBirthday)));
        return output.toString();
    }
}
