package com.example.social_login.controller;

import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

    // 1. Sabse pehle ye chalega login ke baad (Ab ye /user par hai)
    @GetMapping("/user")
    public String greet(@AuthenticationPrincipal OAuth2User principal) {
    	String name = principal.getAttribute("name");
        if (name == null) name = principal.getAttribute("login"); // Username if name is null
        
        return "<h1>Hey " + name + "</h1>" +
               "<p>OAuth implementation successful!</p>" +
               "<a href='/logout'>Logout karke dekho</a>"; // Logout link        
        }
	
    // 2. User ka saara data dekhne ke liye
    @GetMapping("/details")
    public Map<String, Object> getUserDetails(@AuthenticationPrincipal OAuth2User principal) {
        return principal.getAttributes();
    }

    // 3. Public home page (Sab ke liye)
    @GetMapping("/")
    public String home() {
    	return "<h1>Welcome to Home Page</h1>" +
                "<p>Ye page sabke liye open hai.</p>" +
                "<a href='/user'>Login with GitHub</a>";
    }

    // 4. Secured page
    @GetMapping("/secured")
    public String secured() {
        return "Hello, you are in the Secured Area!";
    }
}

