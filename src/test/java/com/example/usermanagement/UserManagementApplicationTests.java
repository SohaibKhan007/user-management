package com.example.usermanagement;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Test class for UserManagementApplication.
 * Ensures that the application context loads successfully and the main method is covered.
 */
@SpringBootTest
public class UserManagementApplicationTests {

    /**
     * Tests that the application context loads without any issues.
     * This is a basic sanity check for the Spring Boot application.
     */
    @Test
    public void contextLoads() {
        // This test will pass if the application context loads successfully.
        // No additional assertions are needed as Spring Boot will throw an exception if the context fails to load.
    }

    /**
     * Tests the main method to ensure it starts the application.
     * This covers the main method for code coverage purposes.
     */
    @Test
    public void testMain() {
        // Use mockStatic to mock the static method SpringApplication.run
        try (var mockedSpringApplication = mockStatic(SpringApplication.class)) {
            // Mock the return of SpringApplication.run to avoid starting the server
            mockedSpringApplication.when(() -> SpringApplication.run(UserManagementApplication.class, new String[]{}))
                                   .thenReturn(mock(ConfigurableApplicationContext.class));

            // Call the main method
            UserManagementApplication.main(new String[]{});

            // Verify that SpringApplication.run was called with the correct arguments
            mockedSpringApplication.verify(() -> SpringApplication.run(UserManagementApplication.class, new String[]{}));
        }
    }
}