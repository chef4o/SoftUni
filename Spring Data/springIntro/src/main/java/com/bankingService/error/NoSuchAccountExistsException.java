package com.bankingService.error;

public class NoSuchAccountExistsException extends RuntimeException {
    @Override
    public String toString() {
        return "\nAccount with the provided ID does not exist.";
    }
}
