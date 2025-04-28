package com.lic.backend.controller;

import com.lic.backend.model.User;
import com.lic.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        User user = userRepository.findByUsername(username);

        if (user == null || !user.getPassword().equals(password)) {
            return ResponseEntity.status(401).body("Invalid Credentials");
        }

        // For now, instead of real JWT, just return a dummy token
        return ResponseEntity.ok("dummy-jwt-token-for-" + username);
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username already exists!");
        }

        // Set default role if not already set (optional)
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("ROLE_CUSTOMER"); // Default role
        }

        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully!");
    }

}
