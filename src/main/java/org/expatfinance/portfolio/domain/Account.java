package org.expatfinance.portfolio.domain;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "accounts")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    // Notice we just store the String ID here to enforce domain isolation,
    // rather than creating a complex @ManyToOne relationship right away.
    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type", nullable = false)
    private AccountType accountType; // 'BANK' for MVP [cite: 30]

    @Column(name = "balance", precision = 20, scale = 8, nullable = false)
    private BigDecimal balance;

    @Column(name = "currency", nullable = false, length = 3)
    private String currency;

    @Column(name = "source", nullable = false)
    private String source; // 'MANUAL' for MVP [cite: 116]

    @Column(name = "source_ref")
    private String sourceRef;

    @Column(name = "last_synced", nullable = false)
    private ZonedDateTime lastSynced;

    // Automatically updates the sync time whenever the account is saved/modified
    @PrePersist
    @PreUpdate
    protected void onSync() {
        lastSynced = ZonedDateTime.now();
    }
}