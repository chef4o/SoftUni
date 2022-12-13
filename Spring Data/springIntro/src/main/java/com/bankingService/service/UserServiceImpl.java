package com.bankingService.service;

import com.bankingService.error.NoSuchUserExistsException;
import com.bankingService.error.UserAlreadyExistsException;
import com.bankingService.model.entity.Account;
import com.bankingService.model.entity.User;
import com.bankingService.repository.UserRepository;
import com.bankingService.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public UserServiceImpl(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public void registerUser(String username, Short age, BigDecimal initialAmount) throws UserAlreadyExistsException {

        if (this.userRepository.existsByUsername(username)) {
            throw new UserAlreadyExistsException();
        }

        User user = new User();
        user.setUsername(username);
        user.setAge(age);
        this.userRepository.save(user);
        saveAccount(initialAmount, user);
    }

    @Override
    public void addBankAccount(long userId, BigDecimal amount) throws NoSuchUserExistsException {
        User user = this.userRepository
                .findById(userId)
                .orElseThrow(NoSuchUserExistsException::new);
        saveAccount(amount, user);
    }

    private void saveAccount(BigDecimal initialAmount, User user) {
        Account account = new Account();
        account.setBalance(initialAmount);
        account.setUser(user);
        this.accountRepository.save(account);
    }
}
