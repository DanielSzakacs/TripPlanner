package com.codecool.tripplanner;

import com.codecool.tripplanner.enums.CityName;
import com.codecool.tripplanner.enums.Genre;
import com.codecool.tripplanner.moduls.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class JPA {

    private static JPA jpa = null;
    private static EntityManager entityManager;
    private static EntityManagerFactory entityManagerFactory;

    private JPA() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpaexamplePU");
        entityManager = entityManagerFactory.createEntityManager();
        buildDB();
    }

    public static void populateDb(EntityManager em) {

        Actor actor1 = new Actor("Bruce Willis");
        Movie movie = new Movie("A Good Day to Die Hard", Genre.ACTION);
        Location location = new Location(CityName.BUDAPEST);
        Timeslot timeslot = new Timeslot("2018/10/19 13:00", 15);
        WalkingTour walkingTour = new WalkingTour("Die Hard 5 Tour",100, "Tour starts from Nyugati Pályaudvar.\n" +
                "We are going through the famous Die Hard sequel 5th part shooting locations.",Genre.ACTION);
        location.addMovie(movie);
        movie.addActor(actor1);
        actor1.addMovieToList(movie);
        timeslot.addWalkingTour(walkingTour);
        walkingTour.addLocation(location);
        location.addWalkingtour(walkingTour);
        walkingTour.addTimeslot(timeslot);
        walkingTour.addMovie(movie);
        TripUser user = new TripUser("Timi", "password");
        user.addToTimeSlot(timeslot);



        Actor actor2 = new Actor("Valaki");
        Movie movie1 = new Movie("Horrora akadva", Genre.HORROR);
        Location location1 = new Location(CityName.BUDAPEST);
        Timeslot timeslot1 = new Timeslot("2018.10.19 15:00",15);
        WalkingTour walkingTour1 = new WalkingTour("Horrora akadva tour",200,"gdfhgf",movie1.getGenre());
        location.addMovie(movie1);
        movie1.addActor(actor2);
        actor2.addMovieToList(movie1);
        timeslot1.addWalkingTour(walkingTour1);
        walkingTour1.addLocation(location1);
        location1.addWalkingtour(walkingTour1);
        walkingTour1.addTimeslot(timeslot1);
        walkingTour1.addMovie(movie1);
        TripUser user1 = new TripUser("valaki","password");
        user1.addToTimeSlot(timeslot1);



        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(actor1);
        em.persist(movie);
        em.persist(location);
        em.persist(timeslot);
        em.persist(walkingTour);
        em.persist(user);

        em.persist(actor2);
        em.persist(movie1);
        em.persist(location1);
        em.persist(timeslot1);
        em.persist(walkingTour1);
        em.persist(user1);
        transaction.commit();
        System.out.println("Commitolva lett");
    }

    public static JPA getInstance(){
        if(jpa == null){
            jpa = new JPA();
        }
        return jpa;
    }

    public static EntityManager getEntityManager(){
        if(entityManager == null){
            getInstance();
        }
        return entityManager;

    }

    public static void buildDB() {
        EntityManager em = entityManager;
        populateDb(em);
//        em.clear();
//        em.close();
//        entityManagerFactory.close();
    }

//    public static void main(String[] args) {
//        getInstance();
//        EntityManager em = entityManager;
//        populateDb(em);
//
//        em.clear();
//        em.close();
//        entityManagerFactory.close();
//    }
}
