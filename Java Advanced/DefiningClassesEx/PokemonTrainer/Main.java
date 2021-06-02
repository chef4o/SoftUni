package DefiningClassesEx.PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainersDatabase = new LinkedHashMap<>();

        String input;
        while (!(input = scanner.nextLine()).equals("Tournament")) {
            String[] currentPull = input.split("\\s+");
            String playerName = currentPull[0];
            String pokemonName = currentPull[1];
            String pokemonElement = currentPull[2];
            int pokemonHealth = Integer.parseInt(currentPull[3]);
            Pokemon currentPokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            if (!trainersDatabase.containsKey(playerName)) {
                trainersDatabase.put(playerName, new Trainer(playerName, currentPokemon));
            } else {
                trainersDatabase.get(playerName).pokemonsList.add(currentPokemon);
            }
        }

        while (!(input = scanner.nextLine()).equals("End")) {
            updatePokemonStats(trainersDatabase, input);
        }

        List<String> output = trainersDatabase.values()
                .stream()
                .sorted((a, b) -> Integer.compare(b.numberOfBadges, a.numberOfBadges))
                .map(Trainer::toString)
                .collect(Collectors.toList());

        output.forEach(System.out::println);
    }

    public static void updatePokemonStats(Map<String, Trainer> trainers, String element) {

        trainers.forEach((name, trainer) -> {
            if (trainer.containsElement(trainer.pokemonsList, element)) {
                trainer.numberOfBadges++;
            } else {
                trainer.pokemonsList.forEach(p -> {
                    p.health -= 10;
                });
            }
            trainer.removeDead();
        });
    }
}
