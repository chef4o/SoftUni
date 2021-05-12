package StreamsFilesAndDirectories;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WriteFile {
    public static void main(String[] args) {

        List<Character> skipChars = new ArrayList<>();
        Collections.addAll(skipChars, ',','.','!','?');

        String inputPath = "C:\\NBU\\files\\input.txt";
        String outputPath = "C:\\NBU\\files\\output.txt";

        try (InputStream in = new FileInputStream(inputPath);
             OutputStream out = new FileOutputStream(outputPath)) {

            int currentByte = 0;
            while ((currentByte = in.read()) >= 0) {
                if (!skipChars.contains((char)currentByte)) {
                    out.write(currentByte);
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
