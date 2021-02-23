package BasicSyntax;

import java.util.Scanner;

public class ForeignLanguage {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();

        String output;
        switch (input) {
            case "USA":
            case "England":
                output = "English";
                break;
            case "Spain":
            case "Argentina":
            case "Mexico":
                output = "Spanish";
                break;
            default:
                output = "unknown";
                break;
        }

        System.out.println(output);
    }
}
