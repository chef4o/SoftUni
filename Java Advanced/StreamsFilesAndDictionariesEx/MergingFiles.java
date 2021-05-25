package StreamsFilesAndDictionariesEx;

import java.io.*;
import java.util.*;

public class MergingFiles {
    public static void main(String[] args) throws IOException {

        List<String> combinedInput = new ArrayList<>();
        InputFromFile(combinedInput, "inputOne.txt");
        InputFromFile(combinedInput, "inputTwo.txt");
        ExportResultInFile(combinedInput, "output.txt");
    }

    public static void ExportResultInFile(List<String> list, String fileName) throws IOException {

        PrintWriter writer = new PrintWriter(fileName);

        for (String line : list) {
            writer.println(line);
        }

        writer.close();
    }

    public static void InputFromFile(List<String> list, String fileName) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String input;

        while ((input = reader.readLine()) != null) {
            list.add(input);
        }

        reader.close();
    }
}
