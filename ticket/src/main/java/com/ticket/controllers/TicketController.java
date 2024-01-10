package com.ticket.controllers;

import com.ticket.dto.TicketDTO;
import com.ticket.dto.UserDTO;
import com.ticket.exceptions.APIException;
import com.ticket.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name = "CRUD REST APIs for Ticket Resource",
        description = "CRUD REST APIs - Purchase Ticket, Modify Seat, Get Ticket, Get All Tickets, Get Available Seats, Delete Ticket, Delete All Tickets"
)
@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Operation(
            summary = "Purchase Ticket REST API",
            description = "Purchase Ticket REST API is used to purchase a ticket for a registered user and save it in the database"
    )
    @PostMapping("/{userId}")
    public ResponseEntity<TicketDTO> purchaseTicket(@PathVariable Long userId){
        TicketDTO dto = ticketService.purchaseTicket(userId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Ticket REST API",
            description = "Get Ticket REST API is used to get a ticket from the database"
    )
    @GetMapping("/{ticketId}")
    public ResponseEntity<TicketDTO> getTicketDetails(@PathVariable Long ticketId){
        TicketDTO dto = ticketService.getTicketDetails(ticketId);
        return new ResponseEntity<>(dto, HttpStatus.FOUND);
    }

    @Operation(
            summary = "Get All Tickets REST API",
            description = "Get All Tickets REST API is used to get all tickets from the database"
    )
    @GetMapping
    public ResponseEntity<List<TicketDTO>> getAllTickets(){
        List<TicketDTO> dtos = ticketService.getAllTickets();
        return new ResponseEntity<>(dtos, HttpStatus.FOUND);
    }

    @Operation(
            summary = "Get All Available Seats REST API",
            description = "Get All Available Seats REST API is used to get all avail. seats from the database"
    )
    @GetMapping("/seats")
    public ResponseEntity<List<String>> getAvailSeats(){
        List<String> availableSeats = ticketService.getAvailableSeats();
        return new ResponseEntity<>(availableSeats, HttpStatus.FOUND);
    }

    @Operation(
            summary = "Modify Seat REST API",
            description = "Modify Seat REST API is used to update avail. seat for a ticket in the database"
    )
    @PatchMapping("/{ticketId}")
    public ResponseEntity<TicketDTO> modifySeat(@PathVariable Long ticketId, @Valid @RequestParam String newSeat){
            TicketDTO dto = ticketService.modifySeat(ticketId, newSeat);
            return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete Ticket REST API",
            description = "Delete Ticket REST API is used to delete a ticket from the database"
    )
    @DeleteMapping("/{ticketId}")
    public ResponseEntity<String> removeTicket(@PathVariable Long ticketId){
        String status = ticketService.removeTicket(ticketId);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete All Tickets REST API",
            description = "Delete All Tickets REST API is used to delete all tickets from the database"
    )
    @DeleteMapping
    public ResponseEntity<String> deleteAllTickets(){
        String status = ticketService.deleteAllTickets();
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
