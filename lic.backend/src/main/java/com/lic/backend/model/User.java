package com.lic.backend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String role; // ROLE_AGENT, ROLE_CUSTOMER, ROLE_ADMIN
    private String fullName;
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Policy> customerPolicies;

    @OneToMany(mappedBy = "agent")
    private List<Policy> agentPolicies;

    @OneToMany(mappedBy = "agent")
    private List<Commissions> commissionsEarned;

    public Object getFullName() {
    }

    // Getters and Setters
}
