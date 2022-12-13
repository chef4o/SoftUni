package com.bankingService.error;

public class UserAlreadyExistsException extends RuntimeException {
    @Override
    public String toString() {
        return "\nUser with the provided parameters already exists.";
    }
}
