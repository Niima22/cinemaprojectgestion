package com.idld.MovieRepository.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "global.params")  // Mapping properties from the application.properties
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConfigGlobalMovie {

    private int maxMovies;  // Maximum number of movies
    private int minRating;  // Minimum rating allowed
}
