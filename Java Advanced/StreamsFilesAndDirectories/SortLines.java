package StreamsFilesAndDirectories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) throws IOException {

        List<String> list = Files.readAllLines(Paths.get("C:\\NBU\\input.txt"))
                                                    .stream()
                                                    .sorted(String::compareTo)
                                                    .collect(Collectors.toList());

        Files.write(Paths.get("C:\\NBU\\output.txt"), list);
    }
}
