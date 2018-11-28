package com.codecool.tripplanner.DAO;

import com.codecool.tripplanner.enums.CityName;
import com.codecool.tripplanner.enums.Genre;
import com.codecool.tripplanner.module.*;
import com.codecool.tripplanner.repository.*;
import org.springframework.stereotype.Component;

@Component
public class InitalizeDB {

    public InitalizeDB(ActorRepo actorRepo, LocationaRepo locationaRepo, MovieRepo movieRepo, TimeslotRepo timeslotRepo, WalkingTourRepo walkingTourRepo, TripUserRepo tripUserRepo){

        Movie movie0 = new Movie("A Good Day to Die Hard", Genre.ACTION, CityName.BUDAPEST);
        Movie movie1 = new Movie("I Spy", Genre.COMEDY, CityName.BUDAPEST);
        Movie movie2 = new Movie("Hellboy 2", Genre.ACTION, CityName.ETYEK);
        Movie movie3 = new Movie("Uvegtigris", Genre.COMEDY, CityName.TINNYE);
        Movie movie4 = new Movie("Kincsem", Genre.ADVENTURE, CityName.KESZTHELY);

        Actor actor0 = new Actor("Bruce Willis");
        Actor actor1 = new Actor("Ganxsta Zolee");
        Actor actor2 = new Actor("Eddie Murphy");
        Actor actor3 = new Actor("Owen Wilson");
        Actor actor4 = new Actor("Ron Perlman");
        Actor actor5 = new Actor("Selma Blair");
        Actor actor6 = new Actor("Rudolf Péter");
        Actor actor7 = new Actor("Reviczky Gábor");
        Actor actor8 = new Actor("Nagy Ervin");
        Actor actor9 = new Actor("Petrik Andrea");

        tripUserRepo.save(new TripUser("daniel", "dsa"));


        movieRepo.save(movie0);
        movieRepo.save(movie1);
        movieRepo.save(movie2);
        movieRepo.save(movie3);
        movieRepo.save(movie4);

        actorRepo.save(actor0);
        actorRepo.save(actor1);
        actorRepo.save(actor2);
        actorRepo.save(actor3);
        actorRepo.save(actor4);
        actorRepo.save(actor5);
        actorRepo.save(actor6);
        actorRepo.save(actor7);
        actorRepo.save(actor8);
        actorRepo.save(actor9);

        WalkingTour walkingTour0 = new WalkingTour("Die Hard 5 Tour", 100, "The tour starts from Nyugati palyaudvar.\n" +
                "We are going through the famous Die Hard series' 5th part shooting locations.", movie0.getGenre(), movie0.getCityName());
        Location location0 = new Location(CityName.BUDAPEST);
        Timeslot timeslot0 = new Timeslot("2018.10.19 13:00", 15);

        WalkingTour walkingTour1 = new WalkingTour("I Spy Tour", 80, "The tour starts from Nyugati palyaudvar.\n" +
                "Do you remember when Eddy Murphy and Owen Wilson was hanging above the tunnel? Now you can try that out!", movie1.getGenre(), movie1.getCityName());
        Location location1 = new Location(CityName.BUDAPEST);
        Timeslot timeslot1 = new Timeslot("2018.10.19 15:00", 15);

        WalkingTour walkingTour2 = new WalkingTour("Hellboy 2 Tour", 120, "The tour starts from Nyugati palyaudvar.\n" +
                "Do you like superheroes? Hellboy is summoned from Hell to help the third Reich to win WWII.", movie2.getGenre(), movie2.getCityName());
        Location location2 = new Location(CityName.ETYEK);
        Timeslot timeslot2 = new Timeslot("2018.10.20 16:00", 15);

        WalkingTour walkingTour3 = new WalkingTour("Uvegtigris Tour", 70, "The tour starts from Nyugati palyaudvar.\n" +
                "You can visit the iconic places of the movie.", movie3.getGenre(), movie3.getCityName());
        Location location3 = new Location(CityName.TINNYE);
        Timeslot timeslot3 = new Timeslot("2018.10.20 13:00", 15);

        WalkingTour walkingTour4 = new WalkingTour("Kincsem Tour", 60, "The tour starts from Nyugati palyaudvar.\n" +
                "You can visit the iconic places of the movie.", movie4.getGenre(), movie4.getCityName());
        Location location4 = new Location(CityName.KESZTHELY);
        Timeslot timeslot4 = new Timeslot("2018.10.22 13:00", 15);

        walkingTourRepo.save(walkingTour0);
        locationaRepo.save(location0);
        timeslotRepo.save(timeslot0);

        walkingTourRepo.save(walkingTour1);
        locationaRepo.save(location1);
        timeslotRepo.save(timeslot1);

        walkingTourRepo.save(walkingTour2);
        locationaRepo.save(location2);
        timeslotRepo.save(timeslot2);

        walkingTourRepo.save(walkingTour3);
        locationaRepo.save(location3);
        timeslotRepo.save(timeslot3);

        walkingTourRepo.save(walkingTour4);
        locationaRepo.save(location4);
        timeslotRepo.save(timeslot4);

    }
}
