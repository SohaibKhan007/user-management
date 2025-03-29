package com.example.usermanagement.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Represents a User entity with validation constraints.
 * <p>
 * This class enforces constraints on user attributes such as ID, name, and email,
 * ensuring data consistency and correctness.
 * </p>
 * 
 * <p>Validation Rules:</p>
 * <ul>
 *   <li>ID cannot be negative.</li>
 *   <li>Name must not be empty and cannot exceed 255 characters.</li>
 *   <li>Email must be a valid format and not empty.</li>
 * </ul>
 */
public class User {

    /**
     * Unique identifier for the user.
     * <p>
     * Must be zero or a positive integer.
     * </p>
     */
    @Min(value = 0, message = "ID cannot be negative")
    private int id;

    /**
     * Full name of the user.
     * <p>
     * Must not be blank and should not exceed 255 characters.
     * </p>
     */
    @NotBlank(message = "Name cannot be empty")
    @Size(min = 2, max = 255, message = "Name must be between 2 and 255 characters")
    private String name;

    /**
     * Email address of the user.
     * <p>
     * Must be a valid email format and cannot be empty.
     * </p>
     */
    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;

    /**
     * Default constructor for creating an empty user object.
     */
    public User() {
        // Default constructor
    }

    /**
     * Parameterized constructor for creating a user with specific values.
     * 
     * @param id    User ID (must be non-negative)
     * @param name  User name (must be between 2 and 255 characters)
     * @param email User email (must be a valid email format)
     */
    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    /**
     * Retrieves the user ID.
     * 
     * @return User ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the user ID.
     * 
     * @param id User ID (must be non-negative)
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the user's name.
     * 
     * @return User name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the user's name.
     * 
     * @param name User name (must be between 2 and 255 characters)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the user's email address.
     * 
     * @return User email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email address.
     * 
     * @param email User email (must be a valid format)
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
