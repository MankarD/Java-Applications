package com.ticket.service;

import com.ticket.dto.TicketDTO;
import com.ticket.dto.UserDTO;

import java.util.List;

public interface TicketService {
    TicketDTO purchaseTicket(Long userId);
    TicketDTO getTicketDetails(Long ticketId);
    List<String> getAvailableSeats();
    List<TicketDTO> getAllTickets();
    TicketDTO modifySeat(Long ticketId, String newSeat);
    String removeTicket(Long ticketId);
    String deleteAllTickets();
}
