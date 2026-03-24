package org.expatfinance.portfolio.dto;

import lombok.Data;
import org.expatfinance.portfolio.domain.AccountType;

import java.math.BigDecimal;

@Data
public class AccountRequest {
    private String userId;
    private String name;
    private AccountType accountType;
    private BigDecimal balance;
    private String currency;
}