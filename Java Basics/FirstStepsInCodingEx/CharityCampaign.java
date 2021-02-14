package FirstStepsInCodingEx;

import java.util.Scanner;

public class CharityCampaign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        short campaignDays = Short.parseShort(scanner.nextLine());
        short workers = Short.parseShort(scanner.nextLine());
        short cakes = Short.parseShort(scanner.nextLine());
        short waffles = Short.parseShort(scanner.nextLine());
        short pancakes = Short.parseShort(scanner.nextLine());

        double cakesPrice = cakes * 45;
        double wafflesPrice = waffles * 5.80;
        double pancakesPrice = pancakes * 3.20;

        double totalProfit = (cakesPrice + wafflesPrice + pancakesPrice) * campaignDays * workers;
        double raisedFunds = totalProfit - (totalProfit / 8);

        System.out.printf("%.2f", raisedFunds);
    }
}
