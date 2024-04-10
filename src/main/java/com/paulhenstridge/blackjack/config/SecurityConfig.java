package com.paulhenstridge.blackjack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Disabling CSRF for simplicity in development and testing.
                .authorizeRequests()
                .anyRequest().permitAll() // This line permits all requests without authentication.
                .and()
                .httpBasic(); // Keeping HTTP Basic enabled, so you can add authentication later easily.

        return http.build();
    }
}
