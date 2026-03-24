package org.expatfinance.portfolio.controller;


import lombok.RequiredArgsConstructor;
import org.expatfinance.portfolio.domain.Account;
import org.expatfinance.portfolio.dto.AccountRequest;
import org.expatfinance.portfolio.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Account>> getAccounts(@PathVariable String userId){
        List<Account> accounts = accountService.getAccountByUserId(userId);
        if(accounts.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(accounts);
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody AccountRequest accountRequest){
       Account account = accountService.createAccount(accountRequest);
       if(account != null){
           return ResponseEntity.ok(account);
       }
       return ResponseEntity.internalServerError().build();
    }

}
