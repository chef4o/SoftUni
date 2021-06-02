package DefiningClassesEx.PokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer {

    String name;
    int numberOfBadges;
    List<Pokemon> pokemonsList = new ArrayList<>();

    public Trainer(String name, Pokemon pokemon) {
        this.name = name;
        this.pokemonsList.add(pokemon);
    }

    public void removeDead() {
        pokemonsList = pokemonsList.stream()
                .filter(p -> p.health > 0)
                .collect(Collectors.toList());
    }

    public boolean containsElement(List<Pokemon> pokemonList, String comparingElement) {
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.element.equals(comparingElement)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.numberOfBadges, this.pokemonsList.size());
    }
}
