package com.idld.MovieRepository.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "movie.params")  // Mapping properties for movies
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieConfig {

    private String defaultGenre;  // Default genre if not specified
    private int defaultDuration;  // Default duration in minutes
}
