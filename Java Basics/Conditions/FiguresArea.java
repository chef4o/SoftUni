package Conditions;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class FiguresArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double output = 0d;

        switch (input) {

            case "square":
                output = Math.pow(Double.parseDouble(scanner.nextLine()), 2);
                break;
            case "rectangle":
                output = Double.parseDouble(scanner.nextLine())
                        * Double.parseDouble(scanner.nextLine());
                break;
            case "circle":
                output = Math.PI * Math.pow(Double.parseDouble(scanner.nextLine()), 2);
                break;
            case "triangle":
                output = ( Double.parseDouble(scanner.nextLine())
                        * Double.parseDouble(scanner.nextLine())) / 2d;
                break;
        }

        System.out.printf("%.3f", output);
    }
}
