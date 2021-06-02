package DefiningClassesEx.Google;

import java.util.ArrayList;
import java.util.List;

public class Children {
    String childName;
    String childBirthday;
    List<Children> allChildren = new ArrayList<>();

    public Children(String childName, String childBirthday) {
        this.childName = childName;
        this.childBirthday = childBirthday;
    }

    public Children() {

    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Children:").append(System.lineSeparator());
        allChildren.forEach(e -> output.append(String.format("%s %s\n", e.childName, e.childBirthday)));
        return output.toString();
    }
}
