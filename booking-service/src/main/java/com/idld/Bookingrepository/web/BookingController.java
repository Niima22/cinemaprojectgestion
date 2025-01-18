package com.idld.Bookingrepository.web;

import com.idld.Bookingrepository.entities.Booking;
import com.idld.Bookingrepository.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // Create a new booking
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    // Get booking by ID
    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    // Get all bookings for a client
    @GetMapping("/client/{clientId}")
    public List<Booking> getBookingsByClient(@PathVariable Long clientId) {
        return bookingService.getBookingsByClient(clientId);
    }

    // Get all bookings for a movie
    @GetMapping("/movie/{movieId}")
    public List<Booking> getBookingsByMovie(@PathVariable Long movieId) {
        return bookingService.getBookingsByMovie(movieId);
    }

    // Get all bookings
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();  // Fetch all bookings
    }
}
