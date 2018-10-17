package com.codecool.tripplanner.moduls;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class WalkingTour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany
    private List<Movie> movies = new ArrayList<>();

    @OneToOne
    private Timeslot timeslot;
    private int price;
    private String description;

    public WalkingTour() {
    }

    public WalkingTour(int price, String description) {
        this.price = price;
        this.description = description;
    }

    public void addTimeslot(Timeslot timeslot){
        this.timeslot=timeslot;
    }

    public void addMovie(Movie movie){
        this.movies.add(movie);
    }
}
