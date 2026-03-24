package org.expatfinance.portfolio.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;


@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name ="id", nullable = false, updatable = false)
    private String id;


    private String email;

    private String name;

    @Column(name="home_currency")
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
