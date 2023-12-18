package com.example.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails omer = User.builder().username("omer").password("{noop}test123").roles("EMPLOYEE").build();
        UserDetails faruk = User.builder().username("faruk").password("{noop}test123").roles("EMPLOYEE", "MANAGER").build();
        UserDetails tester = User.builder().username("tester").password("{noop}test123").roles("EMPLOYEE", "MANAGER", "ADMIN").build();

        return new InMemoryUserDetailsManager(omer, faruk, tester);
    }
}
