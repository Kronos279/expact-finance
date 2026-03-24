package org.expatfinance.portfolio.service;

import lombok.RequiredArgsConstructor;
import org.expatfinance.portfolio.domain.User;
import org.expatfinance.portfolio.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void syncUser(String uid,String email, String name) {
        userRepository.findById(uid).ifPresentOrElse(
                existingUser -> {

                },
                () -> {

                    User newUser = User.builder()
                            .id(uid)
                            .email(email)
                            .name(name)
                            .build();
                    System.out.println("Create User :- "+ newUser.getEmail());
                    userRepository.save(newUser);
                }
        );
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }


}