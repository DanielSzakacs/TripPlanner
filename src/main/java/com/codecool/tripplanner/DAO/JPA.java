//package com.codecool.tripplanner.DAO;
//
//import com.codecool.tripplanner.enums.CityName;
//import com.codecool.tripplanner.enums.Genre;
//import com.codecool.tripplanner.module.*;
//import org.springframework.stereotype.Component;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//@Component
public class JPA {
//
//    private static JPA jpa = null;
//    private static EntityManager entityManager;
//    private static EntityManagerFactory entityManagerFactory;
//
//    private JPA() {
//        entityManagerFactory = Persistence.createEntityManagerFactory("jpaexamplePU");
//        entityManager = entityManagerFactory.createEntityManager();
//        buildDB();
//    }
//
//    public static void populateDb(EntityManager em) {
//
//        Movie movie0 = new Movie("A Good Day to Die Hard", Genre.ACTION, CityName.BUDAPEST);
//        Movie movie1 = new Movie("I Spy", Genre.COMEDY, CityName.BUDAPEST);
//        Movie movie2 = new Movie("Hellboy 2", Genre.ACTION, CityName.ETYEK);
//        Movie movie3 = new Movie("Uvegtigris", Genre.COMEDY, CityName.TINNYE);
//        Movie movie4 = new Movie("Kincsem", Genre.ADVENTURE, CityName.KESZTHELY);
//
//        Actor actor0 = new Actor("Bruce Willis");
//        Actor actor1 = new Actor("Ganxsta Zolee");
//        Actor actor2 = new Actor("Eddie Murphy");
//        Actor actor3 = new Actor("Owen Wilson");
//        Actor actor4 = new Actor("Ron Perlman");
//        Actor actor5 = new Actor("Selma Blair");
//        Actor actor6 = new Actor("Rudolf Péter");
//        Actor actor7 = new Actor("Reviczky Gábor");
//        Actor actor8 = new Actor("Nagy Ervin");
//        Actor actor9 = new Actor("Petrik Andrea");
//
//        WalkingTour walkingTour0 = new WalkingTour("Die Hard 5 Tour", 100, "The tour starts from Nyugati palyaudvar.\n" +
//                "We are going through the famous Die Hard series' 5th part shooting locations.", movie0.getGenre(), movie0.getCityName());
//        Location location0 = new Location(CityName.BUDAPEST);
//        Timeslot timeslot0 = new Timeslot("2018.10.19 13:00", 15);
//        TripUser user0 = new TripUser("Timi", "password");
//
//        WalkingTour walkingTour1 = new WalkingTour("I Spy Tour", 80, "The tour starts from Nyugati palyaudvar.\n" +
//                "Do you remember when Eddy Murphy and Owen Wilson was hanging above the tunnel? Now you can try that out!", movie1.getGenre(), movie1.getCityName());
//        Location location1 = new Location(CityName.BUDAPEST);
//        Timeslot timeslot1 = new Timeslot("2018.10.19 15:00", 15);
//        TripUser user1 = new TripUser("Timii", "password");
//
//        WalkingTour walkingTour2 = new WalkingTour("Hellboy 2 Tour", 120, "The tour starts from Nyugati palyaudvar.\n" +
//                "Do you like superheroes? Hellboy is summoned from Hell to help the third Reich to win WWII.", movie2.getGenre(), movie2.getCityName());
//        Location location2 = new Location(CityName.ETYEK);
//        Timeslot timeslot2 = new Timeslot("2018.10.20 16:00", 15);
//        TripUser user2 = new TripUser("Timiii", "password");
//
//        WalkingTour walkingTour3 = new WalkingTour("Uvegtigris Tour", 70, "The tour starts from Nyugati palyaudvar.\n" +
//                "You can visit the iconic places of the movie.", movie3.getGenre(), movie3.getCityName());
//        Location location3 = new Location(CityName.TINNYE);
//        Timeslot timeslot3 = new Timeslot("2018.10.20 13:00", 15);
//        TripUser user3 = new TripUser("Timiiii", "password");
//
//        WalkingTour walkingTour4 = new WalkingTour("Kincsem Tour", 60, "The tour starts from Nyugati palyaudvar.\n" +
//                "You can visit the iconic places of the movie.", movie4.getGenre(), movie4.getCityName());
//        Location location4 = new Location(CityName.KESZTHELY);
//        Timeslot timeslot4 = new Timeslot("2018.10.22 13:00", 15);
//        TripUser user4 = new TripUser("Timiiiii", "password");
//
//        createTour(walkingTour0, location0, timeslot0, user0, movie0, actor0, actor1);
//        createTour(walkingTour1, location1, timeslot1, user1, movie1, actor2, actor3);
//        createTour(walkingTour2, location2, timeslot2, user2, movie2, actor4, actor5);
//        createTour(walkingTour3, location3, timeslot3, user3, movie3, actor6, actor7);
//        createTour(walkingTour4, location4, timeslot4, user4, movie4, actor8, actor9);
//
//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
//        persistEntity(em, walkingTour0, location0, timeslot0, user0, movie0, actor0, actor1);
//        persistEntity(em, walkingTour1, location1, timeslot1, user1, movie1, actor2, actor3);
//        persistEntity(em, walkingTour2, location2, timeslot2, user2, movie2, actor4, actor5);
//        persistEntity(em, walkingTour3, location3, timeslot3, user3, movie3, actor6, actor7);
//        persistEntity(em, walkingTour4, location4, timeslot4, user4, movie4, actor8, actor9);
//        transaction.commit();
//        System.out.println("Commitolva lett");
//    }
//
//    private static void createTour(WalkingTour walkingTour, Location location, Timeslot timeslot, TripUser user,
//                                   Movie movie, Actor actor1, Actor actor2) {
//        walkingTour.addLocation(location);
//        walkingTour.addTimeslot(timeslot);
//        walkingTour.addMovie(movie);
//        location.addWalkingtour(walkingTour);
//        location.addMovie(movie);
//        timeslot.addWalkingTour(walkingTour);
//        user.addToTimeSlot(timeslot);
//        movie.addActor(actor1);
//        movie.addActor(actor2);
//        actor1.addMovieToList(movie);
//        actor2.addMovieToList(movie);
//    }
//
//    private static void persistEntity(EntityManager em, WalkingTour walkingTour, Location location, Timeslot timeslot,
//                                      TripUser user, Movie movie, Actor actor1, Actor actor2) {
//        em.persist(walkingTour);
//        em.persist(location);
//        em.persist(timeslot);
//        em.persist(user);
//        em.persist(movie);
//        em.persist(actor1);
//        em.persist(actor2);
//    }
//
//    public static JPA getInstance() {
//        if (jpa == null) {
//            jpa = new JPA();
//        }
//        return jpa;
//    }
//
//    public static EntityManager getEntityManager() {
//        if (entityManager == null) {
//            getInstance();
//        }
//        return entityManager;
//    }
//
//    public static void buildDB() {
//        EntityManager em = entityManager;
//        populateDb(em);
//    }
}
