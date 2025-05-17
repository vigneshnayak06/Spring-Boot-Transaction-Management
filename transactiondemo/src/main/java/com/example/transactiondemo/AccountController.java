package com.example.transactiondemo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;
    private final AccountRepository accountRepository;

    public AccountController(AccountService accountService, AccountRepository accountRepository) {
        this.accountService = accountService;
        this.accountRepository = accountRepository;
    }

    @PostMapping("/create")
    public String createAccount(@RequestParam String name, @RequestParam double balance) {
        accountService.createAccount(name, balance);
        return "Account creation attempted for: " + name;
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountRepository.findById(id).orElseThrow();
    }
}
