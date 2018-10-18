package com.codecool.tripplanner.moduls;

import com.codecool.tripplanner.enums.CityName;

import javax.persistence.*;
import javax.persistence.EnumType;
import java.util.ArrayList;
import java.util.List;
@Entity
@NamedQuery(name = "getalllocations", query = "select l from Location l")
@NamedQuery(name = "Location.getAllWalkingtour", query = "SELECT s.walkingTour FROM Location s WHERE s.cityName = :cityname")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany(mappedBy = "locations")
    private List<Movie> movies = new ArrayList<>();

    @Enumerated(value = EnumType.STRING)
    private CityName cityName;

    @ManyToMany(mappedBy = "location")
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
