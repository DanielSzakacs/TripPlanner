package com.codecool.tripplanner;

import com.codecool.tripplanner.enums.CityName;
import com.codecool.tripplanner.enums.Genre;
import com.codecool.tripplanner.module.WalkingTour;
import com.codecool.tripplanner.repository.WalkingTourRepo;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WalkingTourRepoTest {


    @Autowired
    WalkingTourRepo walkingTourRepo;

    @Autowired
    private TestEntityManager entityManager;

    private List<WalkingTour> walkingTour= new ArrayList<>();

    @Test
    public void WalkingTourRepoGivesBackWalkingTourByParameters(){

        walkingTour.add(new WalkingTour("Lion King",100,"Not The Remake", Genre.ACTION,CityName.BUDAPEST));
        entityManager.persist(walkingTour.get(0));
        entityManager.flush();

        List<WalkingTour> found = walkingTourRepo.findAllByCityNameAndMoviegenre(CityName.BUDAPEST,Genre.ACTION);

        assertThat(walkingTour).isEqualTo(found);


    }


}
