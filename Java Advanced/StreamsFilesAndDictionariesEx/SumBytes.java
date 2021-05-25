package StreamsFilesAndDictionariesEx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

        int currentByte;
        long sum = 0L;

        while ((currentByte = reader.read()) > -1) {

            if (currentByte != 10 && currentByte != 13) {
                sum += currentByte;
            }
        }

        System.out.println(sum);
        reader.close();
    }
}
