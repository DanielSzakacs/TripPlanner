package com.codecool.tripplanner.module;

import com.codecool.tripplanner.enums.CityName;
import com.codecool.tripplanner.enums.Genre;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@NamedQuery(name = "getallmovies",query = "SELECT m from Movie m")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(value = EnumType.STRING)
    private CityName cityName;

    public CityName getCityName() {
        return cityName;
    }

    @ManyToMany
    private List<Actor> actors = new ArrayList<>();

    public long getId() {
        return id;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public List<Location> getLocations() {
        return locations;
    }


    @ManyToMany
    private List<Location> locations = new ArrayList<>();
    private String name;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    public Movie(String name, Genre genre,CityName cityName) {
        this.name = name;
        this.genre = genre;
        this.cityName = cityName;
    }

    public Genre getGenre() {
        return genre;
    }

    public Movie() {
    }

    public void addActor(Actor actor){
        this.actors.add(actor);
    }

    public void addLocation(Location location){
        this.locations.add(location);
    }

    public String getName() {
        return name;
    }
}
