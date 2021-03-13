package ObjectsAndClassesEx;

import java.util.Scanner;

public class Articles {

    static class Article {
        String title;
        String content;
        String author;

        private Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public Article setContent (String content) {
            this.content = content;
            return this;
        }
        public Article setAuthor (String author) {
            this.author = author;
            return this;
        }
        public Article setTitle(String title) {
            this.title = title;
            return this;
        }

        public String toString() {

            return String.format("%s - %s: %s", this.title, this.content, this.author);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] article = scanner.nextLine().split(", ");
        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        Article newArticle = new Article(article[0], article[1], article[2]);

        while (numberOfCommands > 0) {

            String[] input = scanner.nextLine().split(": ");

            switch (input[0]) {
                case "Edit":
                    newArticle.setContent(input[1]);
                    break;
                case "ChangeAuthor":
                    newArticle.setAuthor(input[1]);
                    break;
                case "Rename":
                    newArticle.setTitle(input[1]);
                    break;
            }

            numberOfCommands--;
        }

        System.out.println(newArticle.toString());
    }
}

