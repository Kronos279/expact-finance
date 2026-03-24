package org.expatfinance.portfolio.controller;


import lombok.RequiredArgsConstructor;
import org.expatfinance.portfolio.domain.User;
import org.expatfinance.portfolio.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/sync")
    public ResponseEntity<User> syncUser(Authentication authentication) {
        String uuid = (String) authentication.getPrincipal();

        User user = userService.getUserById(uuid);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        User user = userService.getUserById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }
}