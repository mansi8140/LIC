package com.lic.backend.controller;

import com.lic.backend.model.Commissions;
import com.lic.backend.repository.CommissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api/commissions")
public class CommissionController {

    @Autowired
    private CommissionService commissionService;

    @GetMapping("/my")
    public ResponseEntity<List<Commissions>> getMyCommissions() {
        List<Commissions> commissions = commissionService.getMyCommissions();
        return ResponseEntity.ok(commissions);
    }
}
