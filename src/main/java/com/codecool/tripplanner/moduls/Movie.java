package com.codecool.tripplanner.moduls;

import com.codecool.tripplanner.enums.Genre;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@NamedQuery(name = "getallmovies",query = "SELECT m from Movie m")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany
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
