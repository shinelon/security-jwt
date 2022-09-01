package com.shinelon.securityjwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @ClassName SecurityLoginConfig
 * @Author shinelon
 * @Date 11:19 2022/9/1
 * @Version 1.0
 **/
@Configuration
public class SecurityLoginConfig {

    @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder().username("user").password("user").roles("USER").build();
        UserDetails admin = User.builder().username("admin").password("admin").roles("USER", "ADMIN").build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
