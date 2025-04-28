package com.lic.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/admin/**").hasRole("ADMIN") // Only admins can access
//                        .requestMatchers("/api/user/**").hasAnyRole("USER", "ADMIN") // Users and admins can access
                        .requestMatchers("/api/auth/**").permitAll() // Public access
                        .anyRequest().permitAll())
                .formLogin(form -> form.disable())
                .httpBasic(httpBasic -> httpBasic.disable());
        return http.build();
    }
}
