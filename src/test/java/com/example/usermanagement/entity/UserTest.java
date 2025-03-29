package com.example.usermanagement.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class UserTest {

    private static Validator validator;

    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    /**
     * Test case for setting and getting the user ID.
     */
    @Test
    public void testSetAndGetId() {
        User user = new User();
        user.setId(1); // Setting a valid ID
        assertEquals(1, user.getId()); // Expecting the ID to be 1

        // Testing negative ID scenario
        user.setId(-1);
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertFalse(violations.isEmpty(), "Validation should fail for negative ID");

        // Collect validation messages
        Set<String> errorMessages = violations.stream()
            .map(ConstraintViolation::getMessage)
            .collect(Collectors.toSet());

        assertTrue(errorMessages.contains("ID cannot be negative"),
            "Expected error message not found in: " + errorMessages);
    }

    /**
     * Test case for setting and getting the user name.
     */
    @Test
    public void testSetAndGetName() {
        User user = new User();
        user.setName("John Doe"); // Setting a valid name
        assertEquals("John Doe", user.getName()); // Expecting the name to be "John Doe"

        // Testing empty name scenario
        user.setName("");
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertFalse(violations.isEmpty(), "Validation should fail for empty name");

        Set<String> errorMessages = violations.stream()
            .map(ConstraintViolation::getMessage)
            .collect(Collectors.toSet());

        assertTrue(errorMessages.contains("Name cannot be empty"),
            "Expected error message not found in: " + errorMessages);
    }

    /**
     * Test case for setting and getting the user email.
     */
    @Test
    public void testSetAndGetEmail() {
        User user = new User();
        user.setEmail("john.doe@example.com"); // Setting a valid email
        assertEquals("john.doe@example.com", user.getEmail()); // Expecting the email to match

        // Testing invalid email scenario
        user.setEmail("invalid-email");
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertFalse(violations.isEmpty(), "Validation should fail for invalid email format");

        Set<String> errorMessages = violations.stream()
            .map(ConstraintViolation::getMessage)
            .collect(Collectors.toSet());

        assertTrue(errorMessages.contains("Invalid email format"),
            "Expected error message not found in: " + errorMessages);
    }
}
