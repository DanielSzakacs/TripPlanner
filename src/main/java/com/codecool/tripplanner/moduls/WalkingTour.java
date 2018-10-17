package com.codecool.tripplanner.moduls;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@NamedQuery(name = "displayalltour",query = "SELECT w.location,w.description,w.movies,w.price,w.timeslot from WalkingTour w")
public class WalkingTour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany()
    private List<Movie> movies = new ArrayList<>();

    @OneToOne
    private Timeslot timeslot;

    private int price;
    private String description;

    @ManyToMany
    private List<Location> location = new ArrayList<>();

    public WalkingTour() {
    }

    public WalkingTour(int price, String description) {
        this.price = price;
        this.description = description;
    }

    public void addLocation(Location location){
        this.location.add(location);
    }

    public void addTimeslot(Timeslot timeslot){
        this.timeslot=timeslot;
    }

    public void addMovie(Movie movie){
        this.movies.add(movie);
    }
}
