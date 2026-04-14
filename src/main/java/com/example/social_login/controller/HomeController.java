package com.example.social_login.controller;

import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/user")
    public String greet(@AuthenticationPrincipal OAuth2User principal) {
        // GitHub se user ka naam nikalna
        String name = principal.getAttribute("name");
        return "Hey " + name + ", OAuth implementation successful!";
    }
	
	@GetMapping("/details")
	public Map<String, Object> getUserDetails(@AuthenticationPrincipal OAuth2User principal) {
	    // Ye aapko user ka saara data JSON format mein dikhayega
	    return principal.getAttributes();
	}
	@GetMapping("/")
	public String home() {
		return "Hello, Home!";
	}
	@GetMapping("/secured")
	public String secured() {
		return "Hello, Secured!";
	}
}
