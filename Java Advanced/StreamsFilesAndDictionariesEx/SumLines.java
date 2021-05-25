package StreamsFilesAndDictionariesEx;

import java.io.*;

public class SumLines {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

        String currentLine = reader.readLine();
        int sum = 0;

        while (currentLine != null) {

            for (char c :currentLine.toCharArray()){
                sum += c;
            }
            System.out.println(sum);
            sum = 0;
            currentLine = reader.readLine();
        }

        reader.close();
    }
}
