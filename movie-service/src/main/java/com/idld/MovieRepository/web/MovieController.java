package com.idld.MovieRepository.web;

import com.idld.MovieRepository.entities.movie;
import com.idld.MovieRepository.repositories.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieRepository movieRepository;

    // Constructor to inject the repository
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // Add a new movie (Create operation)
    @PostMapping
    public movie addMovie(@RequestBody movie newMovie) {
        return movieRepository.save(newMovie); // Save the new movie to the database
    }

    // Fetch all movies (Read operation)
    @GetMapping
    public List<movie> getAllMovies() {
        return movieRepository.findAll(); // Retrieve all movies from the database
    }

    // Fetch a specific movie by id (Read operation)
    @GetMapping("/{id}")
    public movie getMovieById(@PathVariable Long id) {
        Optional<movie> movie = movieRepository.findById(id);
        return movie.orElse(null); // Return the movie or null if not found
    }

    // Update a movie (Update operation)
    @PutMapping("/{id}")
    public movie updateMovie(@PathVariable Long id, @RequestBody movie updatedMovie) {
        if (movieRepository.existsById(id)) {
            updatedMovie.setId(id); // Make sure to preserve the ID of the existing movie
            return movieRepository.save(updatedMovie); // Save the updated movie
        }
        return null; // Return null if the movie doesn't exist
    }

    // Delete a movie (Delete operation)
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id); // Delete the movie by ID
        }
    }
}
