package com.example.transactiondemo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final EmailService emailService;

    public AccountService(AccountRepository accountRepository, EmailService emailService) {
        this.accountRepository = accountRepository;
        this.emailService = emailService;
    }

    @Transactional(timeout = 5)
    public void createAccount(String name, double balance) {
        Account account = new Account();
        account.setName(name);
        account.setBalance(balance);
        accountRepository.save(account);

        try {
            emailService.sendEmail(name);
        } catch (Exception e) {
            System.out.println("Email failed: " + e.getMessage());
        }
    }
}
