package com.bankingService.service;

import com.bankingService.error.*;

import java.math.BigDecimal;

public interface UserService {
    void registerUser(
            String username,
            Short age,
            BigDecimal initialAmount) throws UserAlreadyExistsException;

    void addBankAccount(
            long userId,
            BigDecimal amount) throws NoSuchUserExistsException;

}
