package MidExam;

import java.util.*;
import java.util.stream.Collectors;

public class ListManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> listItems =
                Arrays.stream(scanner.nextLine()
                        .split(", "))
                        .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Report")) {

            String[] command = input.split(" ");

            switch (command[0]) {
                case "Blacklist":
                    userBlacklisted(listItems, command[1]);
                    break;
                case "Error":
                    userLost(listItems, Integer.parseInt(command[1]));
                    break;
                case "Change":
                    if (Integer.parseInt(command[1]) < listItems.size()
                            && Integer.parseInt(command[1]) >= 0) {
                        renameUser(listItems, Integer.parseInt(command[1]), command[2]);
                    }
                    break;
            }

        input = scanner.nextLine();
        }

        int blacklistedUsers = 0;
        int lostUsers = 0;
        for (String entry: listItems) {
            if (entry.equals("Lost")) {
                lostUsers++;
            } else if (entry.equals("Blacklisted")) {
                blacklistedUsers++;
            }
        }

        System.out.printf("Blacklisted names: %d \n", blacklistedUsers);
        System.out.printf("Lost names: %d \n", lostUsers);
        System.out.println(listItems.toString().replaceAll("[\\[\\],]", ""));
    }

    static void userBlacklisted(List<String> database, String name) {

        boolean foundEntry = false;
        for (int i = 0; i < database.size(); i++) {

            if (database.get(i).equals(name)){
                System.out.printf("%s was blacklisted.\n", database.get(i));
                database.set(i, "Blacklisted");
                foundEntry = true;
            }
        }

        if (!foundEntry) {
            System.out.printf("%s was not found.\n", name);
        }
    }

    static void userLost (List<String> database, int index) {

        if (!database.get(index).equals("Blacklisted")
                && !database.get(index).equals("Lost")) {
            System.out.printf("%s was lost due to an error.\n", database.get(index));
            database.set(index, "Lost");
        }
    }

    static void renameUser (List<String> database, int index, String newName) {

            System.out.printf("%s changed his username to %s.\n", database.get(index), newName);
            database.set(index, newName);
    }
}
