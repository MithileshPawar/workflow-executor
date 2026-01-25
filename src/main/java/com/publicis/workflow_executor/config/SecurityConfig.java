package com.publicis.workflow_executor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for basic auth in APIs
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated() // Secure all requests
                )
                .httpBasic(Customizer.withDefaults()); // Enable HTTP Basic authentication
        return http.build();
    }
}
