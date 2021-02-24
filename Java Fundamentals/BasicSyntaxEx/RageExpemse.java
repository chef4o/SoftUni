package BasicSyntaxEx;
import java.util.Scanner;

public class RageExpemse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGames = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        double damage = headsetPrice * (lostGames / 2) +
                        mousePrice * (lostGames / 3) +
                        keyboardPrice * (lostGames / 6) +
                        displayPrice * (lostGames / 12);

        System.out.printf("Rage expenses: %.2f lv.", damage);
    }
}
