package com.codecool.tripplanner.repository;

import com.codecool.tripplanner.module.TripUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface TripUserRepo extends JpaRepository<TripUser, Long> {

    @Transactional
    TripUser findTripUserByUsername(String email);
}
