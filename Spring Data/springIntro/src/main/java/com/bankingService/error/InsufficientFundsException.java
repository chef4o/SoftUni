package com.bankingService.error;

public class InsufficientFundsException extends RuntimeException {
    @Override
    public String toString() {
        return "\nThe user does not have sufficient funds to process the transaction.";
    }
}
