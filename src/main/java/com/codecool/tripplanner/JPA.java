package com.codecool.tripplanner;

import com.codecool.tripplanner.enums.CityName;
import com.codecool.tripplanner.enums.Genre;
import com.codecool.tripplanner.moduls.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
        Actor actor3 = new Actor("Ganxsta Zolee");
        Movie movie = new Movie("A Good Day to Die Hard", Genre.ACTION);
        Location location = new Location(CityName.BUDAPEST);
        Timeslot timeslot = new Timeslot("2018.10.19 13:00", 15);
        WalkingTour walkingTour = new WalkingTour("Die Hard 5 Tour",100, "The tour starts from Nyugati palyaudvar.\n" +
                "We are going through the famous Die Hard series' 5th part shooting locations.",movie.getGenre());
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
        WalkingTour walkingTour1 = new WalkingTour("I Spy Tour",80,"The tour starts from Nyugati palyaudvar.\n" +
                "Do you remember when Eddy Murphy and Owen Wilson was hanging above the tunnel? Now you can try that out!",movie1.getGenre());
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
        Movie movie2 = new Movie("Hellboy 2", Genre.ACTION);
        Location location2 = new Location(CityName.ETYEK);
        Timeslot timeslot2 = new Timeslot("2018.10.20 16:00",15);
        WalkingTour walkingTour2 = new WalkingTour("Hellboy 2 Tour",120,"The tour starts from Nyugati palyaudvar.\n" +
                "Do you like superheroes? Hellboy is summoned from Hell to help the third Reich to win WWII.",movie2.getGenre());
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

        Actor actor7 = new Actor("Rudolf Péter");
        Actor actor8 = new Actor("Reviczky Gábor");
        Movie movie3 = new Movie("Uvegtigris", Genre.COMEDY);
        Location location3 = new Location(CityName.TINNYE);
        Timeslot timeslot3 = new Timeslot("2018.10.20 13:00",15);
        WalkingTour walkingTour3 = new WalkingTour("Uvegtigris Tour",70,"The tour starts from Nyugati palyaudvar.\n" +
                "You can visit the iconic places of the movie.",movie3.getGenre());
        location.addMovie(movie3);
        movie3.addActor(actor7);
        movie3.addActor(actor8);
        actor7.addMovieToList(movie3);
        actor8.addMovieToList(movie3);
        timeslot3.addWalkingTour(walkingTour3);
        walkingTour3.addLocation(location3);
        location3.addWalkingtour(walkingTour3);
        walkingTour3.addTimeslot(timeslot3);
        walkingTour3.addMovie(movie3);
        TripUser user3 = new TripUser("Timiiii","password");
        user3.addToTimeSlot(timeslot3);

        Actor actor9 = new Actor("Nagy Ervin");
        Actor actor10 = new Actor("Petrik Andrea");
        Movie movie4 = new Movie("Kincsem", Genre.ADVENTURE);
        Location location4 = new Location(CityName.KESZTHELY);
        Timeslot timeslot4 = new Timeslot("2018.10.22 13:00",15);
        WalkingTour walkingTour4 = new WalkingTour("Kincsem Tour",60,"The tour starts from Nyugati palyaudvar.\n" +
                "You can visit the iconic places of the movie.",movie4.getGenre());
        location.addMovie(movie4);
        movie4.addActor(actor9);
        movie4.addActor(actor10);
        actor9.addMovieToList(movie4);
        actor10.addMovieToList(movie4);
        timeslot4.addWalkingTour(walkingTour4);
        walkingTour4.addLocation(location4);
        location4.addWalkingtour(walkingTour4);
        walkingTour4.addTimeslot(timeslot4);
        walkingTour4.addMovie(movie4);
        TripUser user4 = new TripUser("Timiiiii","password");
        user4.addToTimeSlot(timeslot4);



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

        em.persist(actor7);
        em.persist(actor8);
        em.persist(movie3);
        em.persist(location3);
        em.persist(timeslot3);
        em.persist(walkingTour3);
        em.persist(user3);

        em.persist(actor9);
        em.persist(actor10);
        em.persist(movie4);
        em.persist(location4);
        em.persist(timeslot4);
        em.persist(walkingTour4);
        em.persist(user4);

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
