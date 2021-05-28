package DefiningClasses;

public class BankAccount {

    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccountCount = 1;

    private int customerId;
    private double balance;

    public BankAccount() {
        this.customerId = bankAccountCount++;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    double getInterest (int years) {
        return this.balance * years * BankAccount.interestRate;
    }

    public void deposit (double amount) {
        this.balance += amount;
    }
}
