package DefiningClasses;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankAccountsSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> accountsDatabase = new HashMap<>();

        String input;
        while (!"End".equals(input = scanner.nextLine())) {

            String[] command = input.split("\\s+");

            String output = null;

            switch (command[0]) {
                case "Deposit":
                    int customerId = Integer.parseInt(command[1]);
                    int amount = Integer.parseInt(command[2]);

                    if (BankAccountExists(accountsDatabase, customerId)) {
                        accountsDatabase.get(customerId).deposit(amount);
                        output = String.format("Deposited %d to ID%d", amount, customerId);
                    } else {
                        output = "Account does not exist";
                    }
                    break;
                case "SetInterest":
                    double newInterest = Double.parseDouble(command[1]);
                    BankAccount.setInterestRate(newInterest);
                    break;
                case "GetInterest":
                    customerId = Integer.parseInt(command[1]);
                    int years = Integer.parseInt(command[2]);

                    output = BankAccountExists(accountsDatabase, customerId)
                            ? String.format("%.2f", accountsDatabase.get(customerId).getInterest(years))
                            : "Account does not exist";
                    break;
                default:
                    BankAccount bankAccount = new BankAccount();
                    accountsDatabase.put(bankAccount.getCustomerId(), bankAccount);
                    output = String.format("Account ID%d created", bankAccount.getCustomerId());
                    break;
            }

            if (output != null) {
                System.out.println(output);
            }
        }
    }

    public static boolean BankAccountExists(Map<Integer, BankAccount> database, int id) {
        return database.containsKey(id);
    }
}
