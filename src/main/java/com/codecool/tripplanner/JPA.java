package com.codecool.tripplanner;

import com.codecool.tripplanner.*;
import com.codecool.tripplanner.enums.CityName;
import com.codecool.tripplanner.enums.Genre;
import com.codecool.tripplanner.moduls.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class JPA {

    public static void populateDb(EntityManager em) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));

        Actor actor1 = new Actor("Miki");
        Movie movie = new Movie("Code is life", Genre.ACTION);
        movie.addActor(actor1);
        actor1.addMovieToList(movie);

        Location location = new Location(CityName.BUDAPEST);
        location.addMovie(movie);

        Timeslot timeslot = new Timeslot(LocalDateTime.now(), 5);
        WalkingTour walkingTour = new WalkingTour(300, "Itt most van valami a vizben");
        timeslot.addWalkingTour(walkingTour);
        walkingTour.addTimeslot(timeslot);
        walkingTour.addMovie(movie);

        User user = new User("Timi", "password");
        user.addToTimeSlot(timeslot);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(actor1);
        em.persist(movie);
        em.persist(location);
        em.persist(timeslot);
        em.persist(walkingTour);
        em.persist(user);
        transaction.commit();
        System.out.println("Commitolva lett");
    }


    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaexamplePU");
        EntityManager em = emf.createEntityManager();

        populateDb(em);
        em.clear();

        em.close();
        emf.close();
    }
}
