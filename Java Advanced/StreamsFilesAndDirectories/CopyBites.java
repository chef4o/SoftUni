package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyBites {
    public static void main(String[] args) throws IOException {

        FileInputStream input = new FileInputStream("input.txt");
        FileOutputStream output = new FileOutputStream("output2.txt");
        PrintWriter writer = new PrintWriter(output);

        int singleByte = input.read();

        while (singleByte >= 0) {

            if (singleByte == 10 || singleByte == 32) {
                writer.print((char)singleByte);
            } else {
                writer.print(singleByte);
            }

            singleByte = input.read();
        }

        writer.close();
        input.close();
    }
}
