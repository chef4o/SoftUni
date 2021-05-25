package StreamsFilesAndDictionariesEx;

import java.io.*;

public class AllCaps {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileOutputStream("output.txt"));

        String currentLine;

        while ((currentLine = reader.readLine()) != null) {

            String outputString = currentLine.toUpperCase() + System.lineSeparator();
            writer.write(outputString);
        }

        reader.close();
        writer.close();
    }
}
