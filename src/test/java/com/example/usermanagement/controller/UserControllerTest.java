package com.example.usermanagement.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.example.usermanagement.entity.User;
import com.example.usermanagement.service.UserService;

/**
 * Test class for UserController.
 * This class tests the behavior of UserController methods.
 *
 * <p>Test Scenarios:</p>
 * <ul>
 *   <li>Verify that getAllUsers returns the correct list of users.</li>
 *   <li>Ensure createUser successfully creates a user and returns the correct response.</li>
 *   <li>Validate that handleValidationExceptions correctly handles validation errors.</li>
 * </ul>
 */
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private User user1;
    private User user2;

    /**
     * Sets up test data before each test method.
     * Initializes User objects with valid data.
     *
     * <p>Preconditions:</p>
     * <ul>
     *   <li>user1 and user2 must be initialized with valid attributes.</li>
     * </ul>
     */
    @BeforeEach
    public void setUp() {
        user1 = new User(1, "John Doe", "john.doe@example.com");
        user2 = new User(2, "Jane Smith", "jane.smith@example.com");
    }

    /**
     * Tests the getAllUsers method.
     * Verifies that the method returns a list of users.
     *
     * <p>Test Steps:</p>
     * <ol>
     *   <li>Mock UserService to return a list of users.</li>
     *   <li>Call getAllUsers from UserController.</li>
     *   <li>Assert that the returned list matches expectations.</li>
     * </ol>
     */
    @Test
    public void testGetAllUsers() {
        when(userService.getAllUsers()).thenReturn(Arrays.asList(user1, user2));

        List<User> users = userController.getAllUsers();

        assertEquals(2, users.size(), "The size of the user list should be 2");
        assertEquals(user1, users.get(0), "The first user should be user1");
        assertEquals(user2, users.get(1), "The second user should be user2");
    }

    /**
     * Tests the createUser method.
     * Verifies that a user is created successfully.
     *
     * <p>Test Steps:</p>
     * <ol>
     *   <li>Mock UserService to allow saving a user.</li>
     *   <li>Call createUser from UserController.</li>
     *   <li>Assert that the response status is OK and message is correct.</li>
     *   <li>Verify that userService.saveUser was called.</li>
     * </ol>
     */
    @Test
    public void testCreateUser() {
        doNothing().when(userService).saveUser(any(User.class));

        ResponseEntity<String> response = userController.createUser(user1);

        assertEquals(HttpStatus.OK, response.getStatusCode(), "Response status should be OK");
        assertEquals("User created successfully", response.getBody(), "Response body should indicate success");

        verify(userService).saveUser(user1);
    }

    /**
     * Tests the handleValidationExceptions method.
     * Verifies that validation errors are handled correctly.
     *
     * <p>Test Steps:</p>
     * <ol>
     *   <li>Mock a BindingResult with a field error.</li>
     *   <li>Create a MethodArgumentNotValidException using the mocked BindingResult.</li>
     *   <li>Call handleValidationExceptions from UserController.</li>
     *   <li>Assert that the errors map contains the expected field error.</li>
     * </ol>
     */
    @Test
    public void testHandleValidationExceptions() {
        BindingResult bindingResult = org.mockito.Mockito.mock(BindingResult.class);
        FieldError fieldError = new FieldError("user", "name", "Name is required");
        when(bindingResult.getFieldErrors()).thenReturn(Arrays.asList(fieldError));

        MethodArgumentNotValidException ex = new MethodArgumentNotValidException(null, bindingResult);

        Map<String, String> errors = userController.handleValidationExceptions(ex);

        assertEquals(1, errors.size(), "Errors map should contain one error");
        assertEquals("Name is required", errors.get("name"), "Error message should match the expected message");
    }
}
