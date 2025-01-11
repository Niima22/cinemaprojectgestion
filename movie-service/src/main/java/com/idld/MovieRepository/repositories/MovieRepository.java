package com.idld.MovieRepository.repositories;

import com.idld.MovieRepository.entities.movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@RepositoryRestResource
public interface MovieRepository extends JpaRepository<movie, Long> {
    // Custom query methods for searching and filtering
    List<movie> findByTitleContainingIgnoreCase(String title);
    List<movie> findByGenre(String genre);
    List<movie> findByDirectorContainingIgnoreCase(String director);
}
