package org.expatfinance.portfolio.domain;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
@Table(name = "reference_rates")
@Data
public class ReferenceRate {

    @Id
    @Column(name = "currency_code", nullable = false, length = 3, updatable = false)
    private String currencyCode;

    @Column(name = "central_bank", nullable = false)
    private String centralBank;

    @Column(name = "rate", precision = 5, scale = 2, nullable = false)
    private BigDecimal rate;

    @Column(name = "last_updated", nullable = false)
    private ZonedDateTime lastUpdated;

    @PrePersist
    @PreUpdate
    protected void onUpdate() {
        lastUpdated = ZonedDateTime.now();
    }
}
