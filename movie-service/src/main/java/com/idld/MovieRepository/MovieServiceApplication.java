package com.idld.MovieRepository;

import com.idld.MovieRepository.config.ConfigGlobalMovie;
import com.idld.MovieRepository.config.MovieConfig;
import com.idld.MovieRepository.entities.movie;
import com.idld.MovieRepository.repositories.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties({ConfigGlobalMovie.class, MovieConfig.class})  // Enable configuration properties

public class MovieServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner debut(MovieRepository movieRepository) {

        return args -> {
            // Adding some movie data for testing
            movie m1 = movie.builder()
                    .title("Inception")
                    .genre("Sci-Fi")
                    .director("Christopher Nolan")
                    .releaseDate(java.time.LocalDate.of(2010, 7, 16))
                    .rating(8.8)
                    .duration(2.8)
                    .build();

            movieRepository.save(m1);

            movie m2 = movie.builder()
                    .title("The Dark Knight")
                    .genre("Action")
                    .director("Christopher Nolan")
                    .releaseDate(java.time.LocalDate.of(2008, 7, 18))
                    .rating(9.0)
                    .duration(2.5)
                    .build();

            movieRepository.save(m2);

            movie m3 = movie.builder()
                    .title("Interstellar")
                    .genre("Sci-Fi")
                    .director("Christopher Nolan")
                    .releaseDate(java.time.LocalDate.of(2014, 11, 7))
                    .rating(8.6)
                    .duration(2.9)
                    .build();

            movieRepository.save(m3);

            System.out.println("=============");
            movie m = movieRepository.findById(1L).orElse(null);
            if (m != null) {
                System.out.println("Title: " + m.getTitle() + ", Rating: " + m.getRating());
            }
        };
    }
}
