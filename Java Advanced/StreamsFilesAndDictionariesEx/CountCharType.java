package StreamsFilesAndDictionariesEx;

import java.io.*;
import java.util.*;

public class CountCharType {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileOutputStream("output.txt"));

        Map<String, Integer> outputData = new LinkedHashMap<>();
        outputData.put("Vowels: ", 0);
        outputData.put("Consonants: ", 0);
        outputData.put("Punctuation: ", 0);

        int nextChar;
        while ((nextChar = reader.read()) >= 0) {

            if (charType(nextChar) == 0) {
                outputData.put("Vowels: ", outputData.get("Vowels: ") + 1);
            } else if (charType(nextChar) == 1) {
                outputData.put("Consonants: ", outputData.get("Consonants: ") + 1);
            } else if (charType(nextChar) == 2) {
                outputData.put("Punctuation: ", outputData.get("Punctuation: ") + 1);
            }
        }

        reader.close();

        for (Map.Entry<String, Integer> entry : outputData.entrySet()) {

            writer.print(entry.getKey());
            writer.print(entry.getValue());
            writer.print(System.lineSeparator());
        }

        writer.close();
    }

    public static int charType (int c) {

        // 0 = vowel ; 1 = consonant ; 2 = punctuation ; -1 = other

        List<Integer> vowels = new ArrayList<>()
        {{add(97); add(101); add(105); add(111); add(117); }};

        List<Integer> punctuation = new ArrayList<>()
        {{add(33); add(44); add(46); add(63); }};

        if (vowels.contains(c)) {
            return 0;
        }

        if (punctuation.contains(c)) {
            return 2;
        }

        if (c >= 33 && c <= 122) {
            return 1;
        }

        return -1;
    }
}
