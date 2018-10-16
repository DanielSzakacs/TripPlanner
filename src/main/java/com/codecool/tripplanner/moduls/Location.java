package com.codecool.tripplanner.moduls;

import com.codecool.tripplanner.enums.CityName;

import javax.persistence.*;
import javax.persistence.EnumType;
import java.util.ArrayList;
import java.util.List;

public class Location {

    @ManyToMany
    private List<Movie> movies = new ArrayList<>();

    @Enumerated(value = EnumType.STRING)
    private CityName cityName;

    public Location(CityName cityName) {
        this.cityName = cityName;
    }

    public void addMovie(Movie movie){
        this.movies.add(movie);
    }
}
