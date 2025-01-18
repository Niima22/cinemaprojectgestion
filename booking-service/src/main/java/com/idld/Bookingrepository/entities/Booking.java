package com.idld.Bookingrepository.entities;

import com.idld.Bookingrepository.modele.Client;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBooking; // Change to idBooking for clarity

    private Integer quantity; // Quantity of tickets

    private Long movieId; // Referencing movie by its ID
    @Transient
    private MovieDTO movie; // Will be populated from the Movie Service

    private Long clientId; // Referencing client by their ID
    @Transient
    private Client client; // Will be populated from the Client Service
}
