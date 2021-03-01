package AssociativeArraysEx;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> database = new TreeMap<>();

        while (!input.equals("End")) {

            String[] companyData = input.split("->");
            String companyName = companyData[0];
            String employeeID = companyData[1];

            if (!database.containsKey(companyName)) {
                database.put(companyName, new ArrayList<>());
            }

            if (!database.get(companyName).contains(employeeID)) {
                database.get(companyName).add(employeeID);
            }

            input = scanner.nextLine();
        }

        database.entrySet()
                .stream()
                .forEach(e -> {
                    System.out.println(e.getKey().replaceAll(" ", ""));
                    e.getValue()
                            .stream()
                            .forEach(id -> System.out.printf("--%s\n", id));
        });
    }
}
