package com.bankingService.error;

public class NoSuchUserExistsException extends RuntimeException {
    @Override
    public String toString() {
        return "\nUser with the provided parameters does not exist.";
    }
}
