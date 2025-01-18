package com.idld.Bookingrepository;

import com.idld.Bookingrepository.entities.Booking;
import com.idld.Bookingrepository.repositories.BookingRepository; // Updated to BookingRepository
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class BookingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BookingRepository bookingRepository) {  // Updated to BookingRepository

        return args -> {

            // Sample bookings added for testing
            Booking cm1 = Booking.builder()
                    .clientId(1L)  // Ensure this matches the correct field in Booking class
                    .movieId(2L) // Updated from idProduit to idMovie (assumed change)
                    .quantity(30)
                    .build();
            bookingRepository.save(cm1);

            Booking cm2 = Booking.builder()
                    .clientId(1L)  // Ensure this matches the correct field in Booking class
                    .movieId(2L) // Updated from idProduit to idMovie
                    .quantity(30)
                    .build();
            bookingRepository.save(cm2);

            Booking cm3 = Booking.builder()
                    .clientId(1L)  // Ensure this matches the correct field in Booking class
                    .movieId(1L)  // Updated from idProduit to idMovie
                    .quantity(5)
                    .build();
            bookingRepository.save(cm3);

            Booking cm4 = Booking.builder()
                    .clientId(2L)  // Ensure this matches the correct field in Booking class
                    .movieId(2L) // Updated from idProduit to idMovie
                    .quantity(7)
                    .build();
            bookingRepository.save(cm4);

            Booking cm5 = Booking.builder()
                    .clientId(3L)  // Ensure this matches the correct field in Booking class
                    .movieId(3L) // Updated from idProduit to idMovie
                    .quantity(10)
                    .build();
            bookingRepository.save(cm5);

        };
    }

}
