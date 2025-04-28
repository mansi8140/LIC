package com.lic.backend.controller;

import com.lic.backend.DTO.CommissionResponseDTO;
import com.lic.backend.model.Commissions;
import com.lic.backend.service.CommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commissions")
public class CommissionController {

    @Autowired
    private CommissionService commissionService;

    @GetMapping("/{agent_id}")
    public ResponseEntity<List<CommissionResponseDTO>> getMyCommissions(@PathVariable("agent_id") Long agent_id) {
        List<CommissionResponseDTO> commissions = commissionService.getMyCommissions(agent_id);
        return ResponseEntity.ok(commissions);
    }
}
