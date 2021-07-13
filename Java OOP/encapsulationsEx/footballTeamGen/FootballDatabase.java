package encapsulationsEx.footballTeamGen;

import java.util.HashMap;
import java.util.Map;

public class FootballDatabase {

    private Map<String, Team> teams;

    public FootballDatabase() {
        this.teams = new HashMap<>();
    }

    public void addTeam(String[] commandLine) {
        String teamName = commandLine[1];
        this.teams.putIfAbsent(teamName, new Team(teamName));
    }

    public void addPlayer(String[] commandLine) {
        String teamName = commandLine[1];
        FootballValidation.teamAvailability(this.teams, teamName);
        String playerName = commandLine[2];
        int endurance = Integer.parseInt(commandLine[3]);
        int sprint = Integer.parseInt(commandLine[4]);
        int dribble  = Integer.parseInt(commandLine[5]);
        int passing = Integer.parseInt(commandLine[6]);
        int shooting = Integer.parseInt(commandLine[7]);
        Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
        this.teams.get(teamName).addPlayer(player);
    }

    public void removePlayer(String[] commandLine) {
        String teamName = commandLine[1];
        FootballValidation.teamAvailability(this.teams, teamName);
        String playerName = commandLine[2];
        FootballValidation.playerAvailability(playerName, this.teams.get(teamName).getPlayers(), teamName);
        this.teams.get(teamName).removePlayer(playerName);
    }

    public void printTeamRating(String[] commandLine) {
        String teamName = commandLine[1];
        FootballValidation.teamAvailability(this.teams, teamName);
        double teamRating = this.teams.get(teamName).getRating();
        System.out.printf("%s - %.0f", teamName, teamRating);
        System.out.println();
    }
}
