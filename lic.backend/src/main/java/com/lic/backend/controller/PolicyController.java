package com.lic.backend.controller;

import com.lic.backend.DTO.PolicyRequestDTO;
import com.lic.backend.model.Policy;
import com.lic.backend.repository.PolicyRepository;
import com.lic.backend.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/policies")
public class PolicyController {

        @Autowired
        private PolicyService policyService;

        @PostMapping
        public ResponseEntity<Policy> createPolicy(@RequestBody PolicyRequestDTO dto) {
            Policy createdPolicy = policyService.createPolicy(dto);
            return new ResponseEntity<>(createdPolicy, HttpStatus.CREATED);
        }
    }

