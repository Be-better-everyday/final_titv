package com.example.final_titv.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.net.http.HttpRequest;

@Configuration
public class UserConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                configurer->configurer
                        .requestMatchers(HttpMethod.GET).hasAnyRole("TEACHER", "MANAGER", "ADMIN")
//                        .requestMatchers(HttpMethod.GET, "api/students/**").hasAnyRole("TEACHER", "MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.POST).hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT).hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
        );

        http.httpBasic(Customizer.withDefaults());

        // Chống giả mạo trạng thái ==> Đọc thêm
        http.csrf(csrf->csrf.disable());
        return http.build();
    }


    @Bean
    @Autowired
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "SELECT username, password, enabled FROM users WHERE username = ?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "SELECT username, role FROM roles WHERE username = ?"
        );
        return jdbcUserDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
