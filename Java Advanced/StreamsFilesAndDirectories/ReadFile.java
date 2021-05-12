package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {

        String inputFilePath = "C:\\NBU\\files\\input.txt";

        try (FileInputStream fileStream = new FileInputStream(inputFilePath)) {

            int singleBite = fileStream.read();
            while (singleBite >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(singleBite));
                singleBite = fileStream.read();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
