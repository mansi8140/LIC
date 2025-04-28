package com.lic.backend.controller;

import com.lic.backend.model.User;
import com.lic.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/allCustomers")
    public ResponseEntity<List<User>> getAllCustomers(){
        List<User> customers = userRepository.findAll()
                .stream()
                .filter(user -> "ROLE_CUSTOMER".equals(user.getRole()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(customers);
    }
}
