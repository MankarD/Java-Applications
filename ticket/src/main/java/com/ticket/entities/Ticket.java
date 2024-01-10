package com.ticket.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;
    private String departureFrom;
    private String departureTo;
    private double price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    @Pattern(regexp = "^(A[1-9]|A10|B[1-9]|B10)$", message = "Seat should be in the format A1 to A10 or B1 to B10")
//    @Schema(description = "Seat should be in the format A1 to A10 or B1 to B10")
    private String seat;
}

