# Social Login using OAuth2 (Google & GitHub)

This is a robust implementation of social authentication using **Spring Boot 3** and **Spring Security**. It allows users to securely log in using their existing Google or GitHub accounts.

## Features
- Secure Login via Google OAuth2.
- Secure Login via GitHub OAuth2.
- User profile data retrieval (Name, Email, Profile Picture).
- Stateless/Stateful session management using Spring Security.

## Tech Stack
- **Language:** Java 17+
- **Framework:** Spring Boot 3.x
- **Security:** Spring Security OAuth2 Client
- **Template Engine:** Thymeleaf (if applicable) / HTML/CSS

## Getting Started

### 1. Prerequisites
- Java 17 or higher
- Maven 3.6+
- Google & GitHub Developer Accounts

### 2. Configuration
Create an `application.yml` file in `src/main/resources` and add your credentials:

```yaml
spring:
  security:
    oauth2:
      client:
        registration:
          google:
            client-id: ${GOOGLE_ID}
            client-secret: ${GOOGLE_SECRET}
          github:
            client-id: ${GITHUB_ID}
            client-secret: ${GITHUB_SECRET}
