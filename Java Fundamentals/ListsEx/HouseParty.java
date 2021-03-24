package ListsEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputs = Integer.parseInt(scanner.nextLine());

        List<String> visitors = new ArrayList<>();

        for (int i = 0; i < inputs; i++) {

            String name = scanner.next();
            String result = scanner.nextLine();

            if (visitors.contains(name)) {

                if (result.equals(" is going!")) {
                    System.out.printf("%s is already in the list!\n", name);
                } else {
                    removeVisitors(visitors, name);
                }
            } else {

                if (result.equals(" is going!")) {
                    visitors.add(name);
                } else {
                    System.out.printf("%s is not in the list!\n", name);
                }
            }
        }

        System.out.println(String.join("\n", visitors));
    }

    static void removeVisitors(List<String> allVisitors, String name) {
        for (int i = 0; i < allVisitors.size(); i++) {
            if (allVisitors.get(i).equals(name)) {
                allVisitors.remove(i);
                break;
            }
        }
    }
}
