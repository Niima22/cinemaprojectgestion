package com.idld.Bookingrepository.repositories;

import com.idld.Bookingrepository.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByClientId(Long clientId);  // Fetch bookings by client ID
    List<Booking> findByMovieId(Long movieId);   // Fetch bookings by movie ID
}
