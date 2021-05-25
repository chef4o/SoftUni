package StreamsFilesAndDictionariesEx;

import java.io.*;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("inputLineNumbers.txt"));
        PrintWriter writer = new PrintWriter(new FileOutputStream("output.txt"));

        int number = 1;
        StringBuilder newLine = new StringBuilder(reader.readLine());

        while (newLine.length() > 0) {

            newLine.insert(0, number + ". ");
            writer.println(newLine);
            number++;

            int nextChar = reader.read();
            if (nextChar == -1) {
                break;
            } else {
                newLine = new StringBuilder();
                newLine.append((char)nextChar);
                newLine.append(reader.readLine());
            }
        }

        reader.close();
        writer.close();
    }
}
