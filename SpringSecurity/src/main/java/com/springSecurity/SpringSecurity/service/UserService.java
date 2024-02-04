package com.springSecurity.SpringSecurity.service;

import com.springSecurity.SpringSecurity.entity.User;
import com.springSecurity.SpringSecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Adding a new user
     *
     * @param user, to add a new user
     * @return a new user
     */
    public User createUser(final User user) {
        user.setUserRoles("ROLE_".concat(user.getUserRoles()));
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        return this.userRepository.save(user);
    }

    /**
     * Get user by their email id
     *
     * @param email to get a single user
     * @return a single user
     */
    public User getUserByEmail(final String email) {
        return this.userRepository.findByUserEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email" + email));
    }


    /**
     * Get all the user
     *
     * @return all the user
     */
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }
}
