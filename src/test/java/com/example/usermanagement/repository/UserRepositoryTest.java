package com.example.usermanagement.repository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.usermanagement.entity.User;

/**
 * Test class for UserRepository.
 * Ensures that database operations are performed correctly.
 */
@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private UserRepository userRepository;

    private User user1;
    private User user2;

    /**
     * Sets up test data before each test method.
     * Initializes User objects with valid data.
     */
    @BeforeEach
    public void setUp() {
        user1 = new User(1, "John Doe", "john.doe@example.com");
        user2 = new User(2, "Jane Smith", "jane.smith@example.com");
    }

    /**
     * Tests the getAllUsers method.
     * Verifies that the method retrieves a list of users from the database.
     */
    @Test
    public void testGetAllUsers() {
        // Premise: JdbcTemplate returns a list of users.
        when(jdbcTemplate.query(anyString(), any(BeanPropertyRowMapper.class)))
            .thenReturn(Arrays.asList(user1, user2));

        // Application Logic: Call the method under test.
        List<User> users = userRepository.getAllUsers();

        // Pass/Fail Condition: The returned list should match the expected list.
        assertEquals(2, users.size(), "The size of the user list should be 2");
        assertEquals(user1, users.get(0), "The first user should be user1");
        assertEquals(user2, users.get(1), "The second user should be user2");
    }

    /**
     * Tests the saveUser method.
     * Verifies that a user is saved to the database.
     */
    @Test
    public void testSaveUser() {
        // Application Logic: Call the method under test.
        userRepository.saveUser(user1);

        // Verify that the jdbcTemplate.update method was called with the correct SQL and parameters.
        verify(jdbcTemplate).update(
            "INSERT INTO users (name, email) VALUES (?, ?)",
            user1.getName(), user1.getEmail()
        );
    }
}