package com.codecool.tripplanner.moduls;

import com.codecool.tripplanner.enums.Genre;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Movie {

    @OneToMany
    private List<Actor> actors = new ArrayList<>();
    @ManyToMany
    private List<Location> locations = new ArrayList<>();
    private String name;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    public Movie(String name, Genre genre) {
        this.name = name;
        this.genre = genre;
    }

    public void addActor(Actor actor){
        this.actors.add(actor);
    }

    public void addLocation(Location location){
        this.locations.add(location);
    }
}
