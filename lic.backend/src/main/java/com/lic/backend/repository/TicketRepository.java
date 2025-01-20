package com.lic.backend.repository;

import com.lic.backend.model.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Tickets, Long> {
    // Fetch tickets for a specific user
    List<Tickets> findByUser_UserId(Long userId);

    // Fetch tickets by status
    List<Tickets> findByStatus(String status);

    // Fetch tickets by priority
    List<Tickets> findByPriority(String priority);
}
