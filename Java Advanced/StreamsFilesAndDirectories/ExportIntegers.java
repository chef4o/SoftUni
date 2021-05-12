package StreamsFilesAndDirectories;

import java.io.*;
import java.util.Scanner;

public class ExportIntegers {
    public static void main(String[] args) throws IOException {

        InputStream input = new FileInputStream("input.txt");
        OutputStream output = new FileOutputStream("output.txt");

        Scanner scanner = new Scanner(input);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                System.out.println(scanner.nextInt());
            }

            scanner.next();
        }
    }
}
