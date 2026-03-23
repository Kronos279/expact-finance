package org.expatfinance.portfolio.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;


@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @Column(name ="id", nullable = false, updatable = false)
    private String id;

    @Column(name="home_currency", nullable = false)
    private String homeCurrency;

    @Column(name="fcm_token")
    private String fcmToken;

    @Column(name = "created_at", nullable = false, updatable = false)
    private ZonedDateTime createdAt;

    @PrePersist
    public void create() {
        if (createdAt == null) {
            createdAt = ZonedDateTime.now();
        }
    }
}
