package com.example.final_titv.config;

import com.example.final_titv.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

        @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                configurer->configurer
                        .requestMatchers(HttpMethod.GET).hasAnyAuthority(
                                "TEACHER", "EDITOR", "ADMIN", "USER")
//                        .requestMatchers(HttpMethod.GET, "api/students/**").hasAnyRole("TEACHER", "MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.POST).hasAnyAuthority("EDITOR", "ADMIN")
                        .requestMatchers(HttpMethod.PUT).hasAnyAuthority("EDITOR", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE).hasAnyAuthority("ADMIN")
        );

        http.httpBasic(Customizer.withDefaults());

        // Chống giả mạo trạng thái ==> Đọc thêm
        http.csrf(csrf->csrf.disable());
        return http.build();
    }
}
