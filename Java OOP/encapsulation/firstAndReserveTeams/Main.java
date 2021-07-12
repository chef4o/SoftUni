package encapsulation.firstAndReserveTeams;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pNum = Integer.parseInt(scanner.nextLine());

        Team team = new Team("Black Eagles");

        while (pNum-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            Person player = new Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3]));
            team.addPlayer(player);
        }

        System.out.println(team.getFirstTeam().size());
        System.out.println(team.getReserveTeam().size());

    }
}
