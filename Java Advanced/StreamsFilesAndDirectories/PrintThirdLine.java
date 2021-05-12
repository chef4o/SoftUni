package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintThirdLine {
    public static void main(String[] args) throws IOException {


        FileInputStream input = new FileInputStream("input.txt");
        FileOutputStream output = new FileOutputStream("output.txt");
        PrintWriter writer = new PrintWriter(output);

        int counter = 1;
        int oneByte = 0;

        while ((oneByte = input.read()) >= 0) {

            if (oneByte == 10) {
                counter++;
            }

            if (counter % 3 == 0) {
                writer.print((char)oneByte);
            }
        }

        writer.close();
        input.close();
    }
}
