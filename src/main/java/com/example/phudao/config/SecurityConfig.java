package com.example.phudao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    // bean => dinh nghia

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder password = passwordEncoder();
        UserDetails user = User.builder()
                .username("HangNT169")
                .password(password.encode("123@123"))
                .roles("user")
                .build();
        // authen =>
        // author => phan quyen
        // token => 1-2 tuan
        return new InMemoryUserDetailsManager(user);

    }

    // nguyenvv ; abcd
    // nguyenvv => abcd => kdfhfdhgrplasjiewrwpeo

}
