package encapsulationsEx.footballTeamGen;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        FootballValidation.correctName(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String player) {
        FootballValidation.playerAvailability(player, this.players, this.name);
        int indexToRemove = -1;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(player)) {
                indexToRemove = i;
                break;
            }
        }
        if (indexToRemove > -1) {
            players.remove(indexToRemove);
        }
    }

    public double getRating() {
        if (players.isEmpty()) {
            return 0d;
        }
        double playersRatingSum = players.stream()
                .mapToDouble(Player::overallSkillLevel)
                .sum();
        double playersCount = players.size();
        return playersRatingSum / playersCount;
    }
}
