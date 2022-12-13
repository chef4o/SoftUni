package com.bankingService.service;

import com.bankingService.error.NoSuchAccountExistsException;
import com.bankingService.model.entity.Account;
import com.bankingService.error.InsufficientFundsException;
import com.bankingService.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal amount, Long id) throws NoSuchAccountExistsException, InsufficientFundsException {
        Account account = this.getAccount(id);
        this.checkFundSufficiency(amount, account);
        account.setBalance(account.getBalance().subtract(amount));
        this.accountRepository.save(account);
    }

    @Override
    public void uploadMoney(BigDecimal amount, Long id) throws NoSuchAccountExistsException {
        Account account = this.getAccount(id);
        account.setBalance(account.getBalance().add(amount));
        this.accountRepository.save(account);
    }

    @Override
    @Transactional
    public void transferBetweenAccounts(Long fromAccId, Long toAccId, BigDecimal amount) throws NoSuchAccountExistsException, InsufficientFundsException {
        this.checkFundSufficiency(amount, this.getAccount(fromAccId));
        this.withdrawMoney(amount, fromAccId);
        this.uploadMoney(amount, toAccId);
    }

    private Account getAccount(Long id) throws NoSuchAccountExistsException {
        return this.accountRepository
                .findById(id)
                .orElseThrow(NoSuchAccountExistsException::new);
    }

    private void checkFundSufficiency(BigDecimal amount, Account fromAccount) throws InsufficientFundsException {
        if (fromAccount.getBalance().compareTo(amount) < 0) {
            throw new InsufficientFundsException();
        }
    }
}
