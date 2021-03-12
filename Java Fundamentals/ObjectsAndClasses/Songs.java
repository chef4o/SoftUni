package ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {

    static class SongData {
        String listType;
        String name;
        String time;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfSongs = Integer.parseInt(scanner.nextLine());
        List<SongData> allDetails = new ArrayList<>();

        while (numberOfSongs > 0) {

            String[] input = scanner.nextLine().split("_");
            SongData currentSong = new SongData();
            currentSong.listType = input[0];
            currentSong.name = input[1];
            currentSong.time = input[2];
            allDetails.add(currentSong);

            numberOfSongs--;
        }

        String outputFilter = scanner.nextLine();

        for (int i = 0; i <allDetails.size(); i++) {
            SongData localCheck = allDetails.get(i);

            if (outputFilter.equals(localCheck.listType) || outputFilter.equals("all")) {
                System.out.println(localCheck.name);
            }
        }
    }
}
