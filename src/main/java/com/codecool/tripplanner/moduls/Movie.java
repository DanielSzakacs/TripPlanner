package com.codecool.tripplanner.moduls;

import com.codecool.tripplanner.enums.Genre;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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

    public Movie() {
    }

    public void addActor(Actor actor){
        this.actors.add(actor);
    }

    public void addLocation(Location location){
        this.locations.add(location);
    }
}
