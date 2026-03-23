package org.expatfinance.portfolio.repository;

import org.expatfinance.portfolio.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LoanRepository extends JpaRepository<Loan, UUID> {

    List<Loan> findByUserId(String userId);

    List<Loan> findByRateType(String rateType);
}
