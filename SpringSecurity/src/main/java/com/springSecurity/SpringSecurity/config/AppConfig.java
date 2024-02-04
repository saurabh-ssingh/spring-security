package com.springSecurity.SpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

    //Service interface for encoding passwords.
    // The preferred implementation is BCryptPasswordEncoder.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //It is used for authenticating user credentials during the login process.
    // The purpose of the AuthenticationManager is to determine if the credentials provided by the user are valid
    // and match the expected credentials.
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) {
        try {
            return builder.getAuthenticationManager();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
