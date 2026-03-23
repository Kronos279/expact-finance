package org.expatfinance.portfolio.repository;


import org.expatfinance.portfolio.domain.RecurringPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.List;


@Repository
public interface RecurringPaymentsRepository extends JpaRepository<RecurringPayment, UUID> {

    List<RecurringPayment> findByUserId(String userId);
}
