package encapsulationsEx.footballTeamGen;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FootballDatabase database = new FootballDatabase();

        String input;
        while (!(input = scanner.nextLine()).equals("END")) {

            String[] command = input.split(";");

            try {
                switch (command[0]) {
                    case "Team":
                        database.addTeam(command);
                        break;
                    case "Add":
                        database.addPlayer(command);
                        break;
                    case "Remove":
                        database.removePlayer(command);
                        break;
                    case "Rating":
                        database.printTeamRating(command);
                        break;
                }
            } catch (IllegalArgumentException iae) {
                System.err.println(iae.getMessage());
            }
        }
    }
}
