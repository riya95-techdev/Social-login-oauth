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
            auth.requestMatchers("/").permitAll(); // Home page sabke liye
            auth.anyRequest().authenticated();      // Baaki sab locked
        })
        .oauth2Login(org.springframework.security.config.Customizer.withDefaults())
        
        // Logout Configuration Start
        .logout(logout -> logout
        	    .logoutUrl("/logout")
        	    .logoutSuccessUrl("/") 
        	    .invalidateHttpSession(true) // Pura session invalidate karo
        	    .clearAuthentication(true)    // User details clear karo
        	    .deleteCookies("JSESSIONID")  // Browser se cookie delete karo
        	    .permitAll()
        	)
        // Logout Configuration End
        
        .build();
	}
	
}
