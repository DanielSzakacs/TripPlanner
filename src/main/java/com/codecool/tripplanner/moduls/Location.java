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

    @ManyToMany
    private List<Movie> movies = new ArrayList<>();

    @Enumerated(value = EnumType.STRING)
    private CityName cityName;

    public Location(CityName cityName) {
        this.cityName = cityName;
    }

    public Location() {
    }

    public void addMovie(Movie movie){
        this.movies.add(movie);
    }
}