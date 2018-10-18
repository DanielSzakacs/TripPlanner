package com.codecool.tripplanner.moduls;

import com.codecool.tripplanner.enums.CityName;

import javax.persistence.*;
import javax.persistence.EnumType;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany(mappedBy = "locations")
    private List<Movie> movies = new ArrayList<>();

    @Enumerated(value = EnumType.STRING)
    private CityName cityName;

    @ManyToMany
    private List<WalkingTour> walkingTour = new ArrayList<>();

    public Location(CityName cityName) {
        this.cityName = cityName;
    }

    public Location() {
    }

    public void addWalkingtour(WalkingTour walkingTour){
        this.walkingTour.add(walkingTour);
    }

    public void addMovie(Movie movie){
        this.movies.add(movie);
    }
}
