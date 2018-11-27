package com.codecool.tripplanner.repository;

import com.codecool.tripplanner.module.WalkingTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface WalkingTourRepo extends JpaRepository<WalkingTour, Long> {
}
