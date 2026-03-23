package org.expatfinance.portfolio.domain;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "loans")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "principal", precision = 20, scale = 8, nullable = false)
    private BigDecimal principal;

    @Column(name = "currency", nullable = false, length = 3)
    private String currency; // Acts as a loose FK to ReferenceRate

    @Enumerated(EnumType.STRING)
    @Column(name = "rate_type", nullable = false)
    private RateType rateType; // 'FIXED' or 'FLOATING'

    @Column(name = "current_rate", precision = 5, scale = 2, nullable = false)
    private BigDecimal currentRate;

    @Column(name = "spread", precision = 5, scale = 2, nullable = false)
    private BigDecimal spread;

    @Column(name = "emi_amount", precision = 20, scale = 8, nullable = false)
    private BigDecimal emiAmount;

    @Column(name = "emi_currency", nullable = false, length = 3)
    private String emiCurrency;
}