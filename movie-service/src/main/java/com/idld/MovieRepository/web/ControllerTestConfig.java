package com.idld.MovieRepository.web;

import com.idld.MovieRepository.config.ConfigGlobalMovie;
import com.idld.MovieRepository.config.MovieConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTestConfig {

    private final ConfigGlobalMovie globalMovie;
    private final MovieConfig movieConfig;

    public ControllerTestConfig(ConfigGlobalMovie globalMovie, MovieConfig movieConfig) {
        this.globalMovie = globalMovie;
        this.movieConfig = movieConfig;
    }

    @GetMapping("/testGlobal")
    public ConfigGlobalMovie testGlobal() {
        return globalMovie;
    }

    @GetMapping("/movieConfig")
    public MovieConfig testMovieConfig() {
        return movieConfig;
    }
}
