package com.idld.Bookingrepository.service;

import com.idld.Bookingrepository.entities.Booking;
import com.idld.Bookingrepository.entities.MovieDTO;
import com.idld.Bookingrepository.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final MovieService movieService;

    @Autowired
    public BookingService(BookingRepository bookingRepository, MovieService movieService) {
        this.bookingRepository = bookingRepository;
        this.movieService = movieService;
    }

    // Method to create a new booking
    public Booking createBooking(Booking booking) {
        // Fetch movie details using the movie service
        MovieDTO movie = movieService.getMovieById(booking.getMovieId()); // Assuming movieId maps to movie ID

        // Attaching movie details to the booking
        booking.setMovie(movie);

        // Saving the booking with movie details
        return bookingRepository.save(booking);
    }

    // Get booking by ID
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null); // Fetching booking by ID
    }

    // Get all bookings for a client
    public List<Booking> getBookingsByClient(Long clientId) {
        return bookingRepository.findByClientId(clientId); // Fetching bookings by client ID
    }

    // Get all bookings for a movie
    public List<Booking> getBookingsByMovie(Long movieId) {
        return bookingRepository.findByMovieId(movieId); // Fetching bookings by movie ID
    }

    // Get all bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll(); // Fetching all bookings
    }
}
