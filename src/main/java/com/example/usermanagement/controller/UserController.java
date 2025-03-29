package com.example.usermanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.usermanagement.entity.User;
import com.example.usermanagement.service.UserService;

import jakarta.validation.Valid;

/**
 * Controller class for managing user-related endpoints.
 * Provides APIs to retrieve and create users.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Retrieves a list of all users.
     *
     * @return List of User objects
     */
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    /**
     * Creates a new user.
     *
     * @param user The User object to be created, validated using @Valid
     * @return ResponseEntity with success message if creation is successful
     */
    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok("User created successfully");
    }

    /**
     * Handles validation exceptions and returns error messages for invalid fields.
     *
     * @param ex MethodArgumentNotValidException instance containing validation errors
     * @return Map of field names and corresponding validation error messages
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
            errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
    }
}
