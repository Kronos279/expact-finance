package org.expatfinance.controllers;

import org.expatfinance.config.AuthUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PingController {

    @GetMapping("/auth/ping")
    public ResponseEntity<Map<String, String>> ping() {
        return ResponseEntity.ok(Map.of("status", "ok"));
    }

    @GetMapping("/auth/me")
    public ResponseEntity<Map<String, String>> me() {
        return ResponseEntity.ok(Map.of("userId", AuthUtils.getCurrentUserId()));
    }
}