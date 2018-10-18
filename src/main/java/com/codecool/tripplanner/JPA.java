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
        Actor actor3 = new Actor("Gangsta Zolee");
        Movie movie = new Movie("A Good Day to Die Hard", Genre.ACTION);
        Location location = new Location(CityName.BUDAPEST);
        Timeslot timeslot = new Timeslot("2018/10/19 13:00", 15);
        WalkingTour walkingTour = new WalkingTour("Die Hard 5 Tour",100, "Tour starts from Nyugati Pályaudvar.\n" +
                "We are going through the famous Die Hard sequel 5th part shooting locations.",movie.getGenre());
        movie.addActor(actor3);
        location.addMovie(movie);
        movie.addActor(actor1);
        actor1.addMovieToList(movie);
        actor3.addMovieToList(movie);
        timeslot.addWalkingTour(walkingTour);
        walkingTour.addLocation(location);
        location.addWalkingtour(walkingTour);
        walkingTour.addTimeslot(timeslot);
        walkingTour.addMovie(movie);
        TripUser user = new TripUser("Timi", "password");
        user.addToTimeSlot(timeslot);

        Actor actor2 = new Actor("Eddie Murphy");
        Actor actor4 = new Actor("Owen Wilson");
        Movie movie1 = new Movie("I Spy", Genre.COMEDY);
        Location location1 = new Location(CityName.BUDAPEST);
        Timeslot timeslot1 = new Timeslot("2018.10.19 15:00",15);
        WalkingTour walkingTour1 = new WalkingTour("I Spy Tour",80,"Tour starts from Nyugati pályaudvar\n" +
                "Do you remmeber when Eddiy Murphy and Owen Wilson was hanging above the tunnel?Now you vna try out!",movie1.getGenre());
        location.addMovie(movie1);
        movie1.addActor(actor2);
        movie1.addActor(actor4);
        actor4.addMovieToList(movie1);
        timeslot1.addWalkingTour(walkingTour1);
        walkingTour1.addLocation(location1);
        location1.addWalkingtour(walkingTour1);
        walkingTour1.addTimeslot(timeslot1);
        walkingTour1.addMovie(movie1);
        TripUser user1 = new TripUser("Timii","password");
        user1.addToTimeSlot(timeslot1);

        Actor actor6 = new Actor("Ron Perlman");
        Actor actor5 = new Actor("Selma Blair");
        Movie movie2 = new Movie("I Spy", Genre.ACTION);
        Location location2 = new Location(CityName.ETYEK);
        Timeslot timeslot2 = new Timeslot("2018.10.20 16:00",15);
        WalkingTour walkingTour2 = new WalkingTour("Hellboy Tour",120,"Tour starts from Nyugati pályaudvar\n" +
                "Do you like superheroes? Hellboy summoned from Hell to help the third Reich to win WWII.This tour you can meet with Ron Perlman",movie2.getGenre());
        location.addMovie(movie2);
        movie2.addActor(actor5);
        movie2.addActor(actor6);
        actor5.addMovieToList(movie2);
        actor6.addMovieToList(movie2);
        timeslot2.addWalkingTour(walkingTour2);
        walkingTour2.addLocation(location2);
        location2.addWalkingtour(walkingTour2);
        walkingTour2.addTimeslot(timeslot2);
        walkingTour2.addMovie(movie2);
        TripUser user2 = new TripUser("Timiii","password");
        user2.addToTimeSlot(timeslot2);


        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(actor1);
        em.persist(actor3);
        em.persist(movie);
        em.persist(location);
        em.persist(timeslot);
        em.persist(walkingTour);
        em.persist(user);

        em.persist(actor2);
        em.persist(actor4);
        em.persist(movie1);
        em.persist(location1);
        em.persist(timeslot1);
        em.persist(walkingTour1);
        em.persist(user1);

        em.persist(actor6);
        em.persist(actor5);
        em.persist(movie2);
        em.persist(location2);
        em.persist(timeslot2);
        em.persist(walkingTour2);
        em.persist(user2);

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
