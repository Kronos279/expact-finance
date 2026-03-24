package org.expatfinance.portfolio.service;

import lombok.RequiredArgsConstructor;
import org.expatfinance.portfolio.domain.Account;
import org.expatfinance.portfolio.dto.AccountRequest;
import org.expatfinance.portfolio.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;


    public Account createAccount(AccountRequest accountRequest) {

        Account account = Account.builder()
                .userId(accountRequest.getUserId())
                .name(accountRequest.getName())
                .accountType(accountRequest.getAccountType())
                .balance(accountRequest.getBalance())
                .currency(accountRequest.getCurrency())
                .source("MANUAL")
                .build();
        return accountRepository.save(account);
    }

    public List<Account> getAccountByUserId(String userId){
       List<Account> accounts =  accountRepository.findByUserId(userId);
       return accounts;
    }
}
