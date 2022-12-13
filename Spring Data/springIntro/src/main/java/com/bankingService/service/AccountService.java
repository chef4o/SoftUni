package com.bankingService.service;

import com.bankingService.error.InsufficientFundsException;
import com.bankingService.error.NoSuchAccountExistsException;

import javax.naming.InsufficientResourcesException;
import java.math.BigDecimal;

public interface AccountService {
    void withdrawMoney(BigDecimal amount, Long id) throws NoSuchAccountExistsException, InsufficientResourcesException, InsufficientFundsException;
    void uploadMoney(BigDecimal amount, Long id) throws NoSuchAccountExistsException;
    void transferBetweenAccounts(Long fromAccId, Long ToAccId, BigDecimal amount) throws NoSuchAccountExistsException, InsufficientFundsException;
}
