package com.bankingService.error;

public class NoSuchServiceException extends RuntimeException {
    @Override
    public String toString() {
        return "\nThe required service does not exist.";
    }
}
