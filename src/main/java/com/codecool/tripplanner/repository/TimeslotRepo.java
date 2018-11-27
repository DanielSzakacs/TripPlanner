package com.codecool.tripplanner.repository;

import com.codecool.tripplanner.module.Timeslot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface TimeslotRepo extends JpaRepository<Timeslot, Long> {
}
