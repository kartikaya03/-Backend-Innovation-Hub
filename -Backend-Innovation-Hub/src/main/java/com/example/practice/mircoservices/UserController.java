package com.example.practice.mircoservices;


import com.example.practice.services.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("/users")
    public class UserController {

        @Autowired
        private UserService userService;

        // Get customer by ID (e.g., when a customer checks their account details)
        @GetMapping("/{id}")
        public ResponseEntity<User> getUserById(@PathVariable Long id) {
            User user = userService.getUserById(id);
            return ResponseEntity.ok(user);
        }

        // Create a new user (e.g., during sign-up)
        @PostMapping
        public ResponseEntity<User> createUser(@RequestBody User user) {
            User createdUser = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        }
    }


