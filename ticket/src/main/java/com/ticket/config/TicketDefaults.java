package com.ticket.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class TicketDefaults {
    @Value("${ticket.price}")
    private double ticketPrice;

    @Value("${ticket.fromLocation}")
    private String fromLocation;

    @Value("${ticket.toLocation}")
    private String toLocation;

    @Value("${ticket.maxSeatsPerSection}")
    private int maxSeatsPerSection;

}

