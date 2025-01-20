package com.idld.Bookingrepository;

import com.idld.Bookingrepository.entities.Booking;
import com.idld.Bookingrepository.entities.MovieDTO;
import com.idld.Bookingrepository.repositories.BookingRepository;
import com.idld.Bookingrepository.service.BookingService;
import com.idld.Bookingrepository.service.MovieService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class BookingServiceApplicationTests {

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private MovieService movieService;

    @InjectMocks
    private BookingService bookingService;

    @Test
    void testCreateBooking() {
        // Arrange
        Booking booking = new Booking();
        booking.setMovieId(1L);
        booking.setQuantity(2);
        booking.setClientId(1L);

        MovieDTO movie = new MovieDTO();
        movie.setId(1L);
        movie.setTitle("Inception");

        when(movieService.getMovieById(1L)).thenReturn(movie);
        when(bookingRepository.save(booking)).thenReturn(booking);

        // Act
        Booking createdBooking = bookingService.createBooking(booking);

        // Assert
        assertEquals("Inception", createdBooking.getMovie().getTitle());
        assertEquals(1L, createdBooking.getMovieId());
    }
}
