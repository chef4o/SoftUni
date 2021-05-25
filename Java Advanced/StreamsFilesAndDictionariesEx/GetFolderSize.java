package StreamsFilesAndDictionariesEx;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class GetFolderSize {
    public static void main(String[] args) throws IOException {

        String path = "filesEx\\Exercises Resources\\";
        File root = new File(path);

        Deque<File> dirsDeque = new ArrayDeque<>();
        dirsDeque.offer(root);

        long totalSize = 0L;

        while (!dirsDeque.isEmpty()) {
            File currentDir = dirsDeque.poll();
            File[] nestedFiles = currentDir.listFiles();

            assert nestedFiles != null;
            for (File object : nestedFiles) {
                if (object.isDirectory()) {
                    dirsDeque.offer(object);
                } else {
                    totalSize += object.length();
                }
            }
        }

        System.out.printf("Folder size: %d", totalSize);
    }
}
