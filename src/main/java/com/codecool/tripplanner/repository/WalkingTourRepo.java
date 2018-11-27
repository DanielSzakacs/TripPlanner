package com.codecool.tripplanner.repository;

import com.codecool.tripplanner.enums.CityName;
import com.codecool.tripplanner.enums.Genre;
import com.codecool.tripplanner.module.WalkingTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface WalkingTourRepo extends JpaRepository<WalkingTour, Long> {

    @Transactional
    List<WalkingTour>findAllByCityNameAndMoviegenre(CityName cityname, Genre genre);
}
