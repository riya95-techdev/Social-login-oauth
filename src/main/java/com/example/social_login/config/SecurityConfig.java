package com.example.social_login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		return http
				.authorizeHttpRequests(auth -> {
                    auth.anyRequest().authenticated(); // Abhi ke liye sab authentication maangte hain
                })
                .oauth2Login(org.springframework.security.config.Customizer.withDefaults()) // YE LINE ZAROORI HAI
                .build();
	}
	
}
