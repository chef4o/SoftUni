package DefiningClassesEx.OpinionPoll;

import java.util.*;

public class Main2 {
    public static void main(String[] args0) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());

        List<Person> peopleDatabase = new ArrayList<>();

        while (people-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            peopleDatabase.add(new Person(name, age));
        }

        for (Person person : peopleDatabase) {
            if (person.getAge() > 30) {
                System.out.println(person.toString());
            }
        }
    }
}
