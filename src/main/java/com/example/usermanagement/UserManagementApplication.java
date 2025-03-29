package com.example.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the User Management Application.
 * This class bootstraps the Spring Boot application.
 */
@SpringBootApplication
public class UserManagementApplication {

    /**
     * Main method to launch the Spring Boot application.
     *
     * @param args Command-line arguments passed during application startup
     */
    public static void main(String[] args) {
        SpringApplication.run(UserManagementApplication.class, args);
    }
}
