package AssociativeArrays;

import java.util.*;

public class Synonims {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int counter = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> synonymsDictionary = new LinkedHashMap<>();

        for (int i = 0; i < counter; i++) {

            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            synonymsDictionary.putIfAbsent(word, new ArrayList<>());
            synonymsDictionary.get(word).add(synonym);
        }

        for (Map.Entry<String, List<String>> word: synonymsDictionary.entrySet()) {

            System.out.printf("%s - %s\n", word.getKey(), String.join(", ", word.getValue()));
        }
    }
}
