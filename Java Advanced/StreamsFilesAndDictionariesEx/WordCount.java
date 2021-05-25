package StreamsFilesAndDictionariesEx;

import java.io.*;
import java.util.*;

public class WordCount {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("words.txt"));
        List<String> checkWords = Arrays.asList(reader.readLine().split("\\s+"));

        reader = new BufferedReader(new FileReader("text.txt"));
        String[] text = reader.readLine().split("\\s+");

        reader.close();

        Map<String, Integer> library = new HashMap<>();

        for (String word : checkWords) {
            library.put(word, 0);
        }

        for (String word : text) {
            if (checkWords.contains(word)) {
                library.put(word, library.get(word) + 1);
            }
        }

        PrintWriter writer = new PrintWriter(new FileOutputStream("output.txt"));

        library.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(e -> writer.write(String.format("%s - %d%s",e.getKey(),
                                                                     e.getValue(),
                                                                     System.lineSeparator())));
        writer.close();
    }
}