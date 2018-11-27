package com.codecool.tripplanner.repository;

import com.codecool.tripplanner.module.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface LocationaRepo extends JpaRepository<Location, Long> {
}
