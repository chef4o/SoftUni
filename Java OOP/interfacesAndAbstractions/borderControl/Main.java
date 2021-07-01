package interfacesAndAbstractions.borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Subject> database = new ArrayList<>();

        String command;
        while (!(command = scanner.nextLine()).equals("End")) {
            String[] checkSubject = command.split("\\s+");
            if (isValid(checkSubject)) {
                addRecord(database, checkSubject);
            }
        }
        String fraudSuffix = scanner.nextLine();
        printFraudsterIDs(database, fraudSuffix);
    }

    public static void printFraudsterIDs(List<Subject> database, String fraudSuffix) {
        database.stream()
                .filter(e -> e.getId().endsWith(fraudSuffix))
                .collect(Collectors.toList())
                .forEach(p -> System.out.println(p.getId()));
    }

    public static void addRecord(List<Subject> database, String[] subject) {

        boolean isRobot = subject.length == 2;

        if (isRobot) {
            String robotModel = subject[0];
            String robotId = subject[1];
            database.add(new Robot(robotModel, robotId));
        } else {
            String name = subject[0];
            int age = Integer.parseInt(subject[1]);
            String id = subject[2];
            database.add(new Citizen(name, age, id));
        }
    }

    public static boolean isValid(String[] entry) {
        if (entry.length < 2 || entry.length > 3) {
            return false;
        }

        Pattern onlyDigits = Pattern.compile("^(\\d+)?");
        Matcher idFormat = onlyDigits.matcher(entry[1]);
        if (entry.length == 2) {
            return idFormat.matches();
        }

        idFormat = onlyDigits.matcher(entry[2]);
        Matcher ageFormat = onlyDigits.matcher(entry[1]);
        if (ageFormat.matches() && Integer.parseInt(entry[1]) <= 0) {
            return false;
        }

        return ageFormat.matches() && idFormat.matches();
    }
}
