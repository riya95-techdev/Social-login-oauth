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
    	// Google uses "name", GitHub usually uses "name" or "login"
        String name = principal.getAttribute("name");
        String email = principal.getAttribute("email"); // Google specific
        
        if (name == null) {
            name = principal.getAttribute("login"); // Fallback for GitHub
        }
        
        return "<html><body>" +
               "<h1>Hey " + name + " (" + (email != null ? email : "No Email") + "), OAuth successful!</h1>" +
               "<br><a href='/logout' style='padding:10px; background-color:red; color:white; text-decoration:none; border-radius:5px;'>Logout</a>" +
               "</body></html>";
        }
	
    // 2. User ka saara data dekhne ke liye
    @GetMapping("/details")
    public Map<String, Object> getUserDetails(@AuthenticationPrincipal OAuth2User principal) {
        return principal.getAttributes();
    }

    // 3. Public home page (Sab ke liye)
    @GetMapping("/")
    public String home() {
    	return "<html><body>" +
                "<h1>Welcome to Home Page</h1>" +
                "<p>Login using one of the providers below:</p>" +
                "<a href='/oauth2/authorization/github'>Login with GitHub</a><br><br>" +
                "<a href='/oauth2/authorization/google'>Login with Google</a>" +
                "</body></html>";
    			
    }

    // 4. Secured page
    @GetMapping("/secured")
    public String secured() {
        return "Hello, you are in the Secured Area!";
    }
}

