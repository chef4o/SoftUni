package ObjectsAndClassesEx;

import java.util.Random;
import java.util.Scanner;

public class AdvMessage {

    static class Messages {

        String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product.",
                "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        String[] events = {"Now I feel good.", "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        public String randomGenerator () {

            Random randomize = new Random();

            return String.format("%s %s %s - %s",
                    phrases[randomize.nextInt(phrases.length)],
                    events[randomize.nextInt(events.length)],
                    authors[randomize.nextInt(authors.length)],
                    cities[randomize.nextInt(cities.length)]);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfReviews = Integer.parseInt(scanner.nextLine());

        Messages newMessage = new Messages();

        for (int i = 0; i < numberOfReviews; i++) {

            System.out.println(newMessage.randomGenerator());
        }
    }
}
