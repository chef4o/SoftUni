package DefiningClassesEx.Google;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {

    String pokemonName;
    String pokemonType;
    List<Pokemon> pokemonsDatabase = new ArrayList<>();

    public Pokemon(String pokemonName, String pokemonType) {
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }

    public Pokemon () {

    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Pokemon:"); output.append(System.lineSeparator());
        pokemonsDatabase.forEach(e -> output.append(String.format("%s %s%s", e.pokemonName, e.pokemonType,
                                                                                System.lineSeparator())));
        return output.toString();
    }
}
