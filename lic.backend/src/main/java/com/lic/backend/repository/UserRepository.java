package com.lic.backend.repository;

import com.lic.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Additional query methods if needed, e.g., findByEmail
    Optional<User> findByEmail(String email);
}
