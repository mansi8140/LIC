package com.lic.backend.controller;

import com.lic.backend.model.Tickets;
import com.lic.backend.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    // Get all tickets
    @GetMapping
    public ResponseEntity<List<Tickets>> getAllTickets() {
        return ResponseEntity.ok(ticketRepository.findAll());
    }

    // Get a ticket by ID
    @GetMapping("/{id}")
    public ResponseEntity<Tickets> getTicketById(@PathVariable Long id) {
        Optional<Tickets> ticket = ticketRepository.findById(id);
        return ticket.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Get tickets for a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Tickets>> getTicketsByUserId(@PathVariable Long userId) {
        List<Tickets> tickets = ticketRepository.findByUser_UserId(userId);
        return ResponseEntity.ok(tickets);
    }

    // Get tickets by status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Tickets>> getTicketsByStatus(@PathVariable String status) {
        List<Tickets> tickets = ticketRepository.findByStatus(status);
        return ResponseEntity.ok(tickets);
    }

    // Get tickets by priority
    @GetMapping("/priority/{priority}")
    public ResponseEntity<List<Tickets>> getTicketsByPriority(@PathVariable String priority) {
        List<Tickets> tickets = ticketRepository.findByPriority(priority);
        return ResponseEntity.ok(tickets);
    }

    // Create a new ticket
    @PostMapping
    public ResponseEntity<Tickets> createTicket(@RequestBody Tickets ticket) {
        Tickets savedTicket = ticketRepository.save(ticket);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTicket);
    }

    // Update a ticket
    @PutMapping("/{id}")
    public ResponseEntity<Tickets> updateTicket(@PathVariable Long id, @RequestBody Tickets ticketDetails) {
        Optional<Tickets> optionalTicket = ticketRepository.findById(id);

        if (optionalTicket.isPresent()) {
            Tickets ticket = optionalTicket.get();
            ticket.setSubject(ticketDetails.getSubject());
            ticket.setDescription(ticketDetails.getDescription());
            ticket.setStatus(ticketDetails.getStatus());
            ticket.setPriority(ticketDetails.getPriority());
            Tickets updatedTicket = ticketRepository.save(ticket);
            return ResponseEntity.ok(updatedTicket);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete a ticket
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        if (ticketRepository.existsById(id)) {
            ticketRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
