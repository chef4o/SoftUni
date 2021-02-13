package FirstStepsInCoding;

import java.util.Scanner;

public class PetShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double dogsFood = Integer.parseInt(scan.nextLine()) * 2.50;
        int otherAnimalsFood = Integer.parseInt(scan.nextLine()) * 4;

        System.out.println(dogsFood + otherAnimalsFood + " lv.");
    }
}