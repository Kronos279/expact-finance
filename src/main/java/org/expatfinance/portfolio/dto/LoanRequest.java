package org.expatfinance.portfolio.dto;

import lombok.Data;
import org.expatfinance.portfolio.domain.RateType;
import java.math.BigDecimal;

@Data
public class LoanRequest {
    private String userId;
    private String name;
    private BigDecimal principal;
    private String currency;
    private RateType rateType;
    private BigDecimal currentRate;
    private BigDecimal spread;
    private BigDecimal emiAmount;
    private String emiCurrency;
}