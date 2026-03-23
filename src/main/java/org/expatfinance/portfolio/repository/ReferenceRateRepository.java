package org.expatfinance.portfolio.repository;


import org.expatfinance.portfolio.domain.ReferenceRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferenceRateRepository extends JpaRepository<ReferenceRate, String> {


}
