package Exam;

import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Long> database = new TreeMap<String, Long>();

        while (!input.toLowerCase().equals("log out")) {

            String[] command = input.split(": ");

            switch (command[0].toLowerCase()) {
                case "new follower":
                    String newFollower = command[1];
                    database.putIfAbsent(newFollower, 0L);
                    break;
                case "like":
                    String username = command[1];
                    long count = Integer.parseInt(command[2]);
                    if (!database.containsKey(username)) {
                        database.put(username, count);
                    } else {
                        database.put(username, database.get(username) + count);
                    }
                    break;
                case "comment":
                    String commenter = command[1];
                    if (!database.containsKey(commenter)) {
                        database.put(commenter, 1L);
                    } else {
                        database.put(commenter, database.get(commenter) + 1);
                    }
                    break;
                case "blocked":
                    String deleteUser = command[1];
                    if (database.containsKey(deleteUser)) {
                        database.remove(deleteUser);
                    } else {
                        System.out.printf("%s doesn't exist.\n", deleteUser);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.printf("%s followers\n", database.size());

        database.entrySet()
                .stream()
                .sorted((x, y) -> y.getValue().compareTo(x.getValue()))
                .forEach(e -> System.out.printf("%s: %d\n", e.getKey(), e.getValue()));
    }
}