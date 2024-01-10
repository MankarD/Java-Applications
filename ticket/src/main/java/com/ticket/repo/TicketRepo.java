package com.ticket.repo;

import com.ticket.entities.Ticket;
import com.ticket.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface TicketRepo extends JpaRepository<Ticket, Long> {
    Optional<Ticket> findBySeat(String seat);
//    Ticket findTopBySeatStartingWithOrderBySeatDesc(String section);
//    Ticket findTopByOrderBySeatDesc();
}
