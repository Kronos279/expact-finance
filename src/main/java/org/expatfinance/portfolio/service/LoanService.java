package org.expatfinance.portfolio.service;

import lombok.RequiredArgsConstructor;
import org.expatfinance.portfolio.domain.Loan;
import org.expatfinance.portfolio.dto.LoanRequest;
import org.expatfinance.portfolio.repository.LoanRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;

    @Transactional
    public Loan createLoan(LoanRequest request) {
        // In the future, we could calculate the total effective rate here:
        // effectiveRate = currentRate + spread

        Loan loan = Loan.builder()
                .userId(request.getUserId())
                .name(request.getName())
                .principal(request.getPrincipal())
                .currency(request.getCurrency())
                .rateType(request.getRateType())
                .currentRate(request.getCurrentRate())
                .spread(request.getSpread())
                .emiAmount(request.getEmiAmount())
                .emiCurrency(request.getEmiCurrency())
                .build();

        return loanRepository.save(loan);
    }

    public List<Loan> getLoansByUserId(String userId) {
        return loanRepository.findByUserId(userId);
    }
}