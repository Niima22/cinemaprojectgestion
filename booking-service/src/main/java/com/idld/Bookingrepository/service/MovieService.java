package com.idld.Bookingrepository.service;

import com.idld.Bookingrepository.entities.MovieDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "movie-service", url = "http://localhost:9092")
public interface MovieService {

    @GetMapping("/movies/{id}")
    MovieDTO getMovieById(@PathVariable("id") Long id);  // Fetch movie details by ID
}
