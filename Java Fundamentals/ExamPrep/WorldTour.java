package ExamPrep;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder stops = new StringBuilder(scanner.nextLine());

        String comm = scanner.nextLine();
        while (!comm.equals("Travel")) {

            String[] command = comm.split(":");
            switch (command[0]) {
                case "Add Stop":
                    if (isValidIndex(command[1], stops)) {
                        stops.insert(Integer.parseInt(command[1]), command[2]);
                    }
                    break;
                case "Remove Stop":
                    if (isValidIndex(command[1], stops) && isValidIndex(command[2], stops)) {
                        stops.replace(Integer.parseInt(command[1]), Integer.parseInt(command[2]) + 1, "");
                    }
                    break;
                case "Switch":
                    stops = new StringBuilder(stops.toString().replace(command[1], command[2]));
                    break;
                default:
                    System.out.println("Unknown command: " + command[0]);
                    break;
            }

            System.out.println(stops);
            comm = scanner.nextLine();
        }

        System.out.printf("Ready for world tour! Planned stops: %s", stops);
    }

    static boolean isValidIndex(String index, StringBuilder source) {

        return Integer.parseInt(index) >= 0 && Integer.parseInt(index) < source.length();
    }
}
