package encapsulationsEx.footballTeamGen;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FootballValidation {
    public static void correctName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
    }

    public static void statState(String statName, int stat) {
        if (stat < 0 || stat > 100) {
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.", statName));
        }
    }

    public static void playerAvailability(String playerName, List<Player> players, String teamName) {
        List<String> playerNames = players.stream().map(Player::getName).collect(Collectors.toList());
        if (!playerNames.contains(playerName)) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.",
                    playerName, teamName));
        }
    }

    public static void teamAvailability (Map<String, Team> teams, String teamName) {
        if (teams.isEmpty() || !teams.containsKey(teamName)) {
            throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
        }
    }
}
