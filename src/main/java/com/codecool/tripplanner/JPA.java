package com.codecool.tripplanner;

import com.codecool.tripplanner.enums.CityName;
import com.codecool.tripplanner.enums.Genre;
import com.codecool.tripplanner.moduls.*;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class JPA {


    private static EntityManager entityManager;
    private static EntityManagerFactory entityManagerFactory;

    private JPA() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpaexamplePU");
        entityManager =entityManagerFactory.createEntityManager();
    }

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
        walkingTour.addLocation(location);
        location.addWalkingtour(walkingTour);
        walkingTour.addTimeslot(timeslot);
        walkingTour.addMovie(movie);

        TripUser user = new TripUser("Timi", "password");
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

    public static EntityManager getInstance(){
        if (entityManager == null){
            new JPA();
        }
        return entityManager;

    }


    public static void main(String[] args) {

        EntityManager em = getInstance();
        populateDb(em);

        List<WalkingTour> result = em.createNamedQuery("displayalltour").getResultList();
        List<Timeslot> timeslots = em.createNamedQuery("getalltimeslot").getResultList();
        List<Movie> movies = em.createNamedQuery("getallmovies").getResultList();
        List<Location> locations = em.createNamedQuery("getalllocations").getResultList();
        List<Actor> actors = em.createNamedQuery("getallactors").getResultList();




        em.clear();


        em.close();
        entityManagerFactory.close();
    }


}
