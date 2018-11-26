package com.codecool.tripplanner.repository;

import com.codecool.tripplanner.module.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface MovieRepo extends JpaRepository<Movie, Long> {
}
