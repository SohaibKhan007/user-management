package com.example.usermanagement.service;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.usermanagement.entity.User;
import com.example.usermanagement.repository.UserRepository;

/**
 * Unit test class for {@link UserService}.
 * Ensures correct behavior of user retrieval and saving methods.
 */
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    /**
     * Mock instance of {@link UserRepository} to simulate database interactions.
     */
    @Mock
    private UserRepository userRepository;

    /**
     * Instance of {@link UserService} being tested.
     * Injects the mocked repository to isolate service logic.
     */
    @InjectMocks
    private UserService userService;

    private User testUser;

    /**
     * Sets up test data before each test execution.
     * Ensures consistency across test runs.
     */
    @BeforeEach
    void setUp() {
        testUser = new User();
        testUser.setId(1);
        testUser.setName("John Doe");
        testUser.setEmail("john.doe@example.com");
    }

    /**
     * Tests the {@link UserService#getAllUsers()} method.
     * Ensures it retrieves a list of users correctly.
     */
    @Test
    void testGetAllUsers_ReturnsUserList() {
        // Premise: Database contains users
        List<User> mockUsers = Arrays.asList(
            new User() {{
                setId(1);
                setName("Alice");
                setEmail("alice@example.com");
            }},
            new User() {{
                setId(2);
                setName("Bob");
                setEmail("bob@example.com");
            }}
        );

        // Mocking repository behavior
        when(userRepository.getAllUsers()).thenReturn(mockUsers);

        // Act: Fetch users
        List<User> retrievedUsers = userService.getAllUsers();

        // Pass Condition: Retrieved list matches mock data
        assertEquals(2, retrievedUsers.size());
        assertEquals("Alice", retrievedUsers.get(0).getName());
        assertEquals("Bob", retrievedUsers.get(1).getName());

        // Verify the repository method was called once
        verify(userRepository, times(1)).getAllUsers();
    }

    /**
     * Tests the {@link UserService#saveUser(User)} method.
     * Ensures user data is correctly passed to the repository for saving.
     */
    @Test
    void testSaveUser_Success() {
        // Act: Save user
        userService.saveUser(testUser);

        // Pass Condition: Verify that repository saveUser() is called with correct user
        verify(userRepository, times(1)).saveUser(testUser);
    }

    /**
     * Tests the {@link UserService#saveUser(User)} method with a null user.
     * Ensures an exception is thrown when trying to save a null user.
     */
    @Test
    void testSaveUser_NullUser_ThrowsException() {
        // Error Condition: Null user should not be saved
        Exception exception = assertThrows(IllegalArgumentException.class, () -> userService.saveUser(null));

        // Pass Condition: Exception message should match
        assertEquals("User cannot be null", exception.getMessage());

        // Verify that repository method is never called
        verify(userRepository, never()).saveUser(any());
    }
}
