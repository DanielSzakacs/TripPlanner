package com.codecool.tripplanner.moduls;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "actors")
    private List<Movie> movieList = new ArrayList<>();

    public Actor(){
    }

    public Actor(String name, List<Movie> movieList) {
        this.name = name;
        this.movieList = movieList;
    }

    public Actor(String name) {
        this.name = name;
    }

    public void setMovieList(List<Movie> movies){
        this.movieList = movies;
    }

    public void addMovieToList(Movie movie){
        this.movieList.add(movie);
    }
}
