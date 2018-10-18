package com.codecool.tripplanner.moduls;

import com.codecool.tripplanner.enums.Genre;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@NamedQueries({
    @NamedQuery(name = "displayalltour",query = "SELECT w from WalkingTour w"),
    @NamedQuery(name = "Walkingtour.getAllWalkingtourByGenre", query = "SELECT s FROM WalkingTour s WHERE s.genre = :walkingtourgenre")
})
public class WalkingTour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany()
    private List<Movie> movies = new ArrayList<>();

    @OneToOne
    private Timeslot timeslot;

    private int price;
    private String description;
    private String tourname;

    public String getTourname() {
        return tourname;
    }

    public Genre getMoviegenre() {
        return moviegenre;
    }

    @Enumerated(value = EnumType.STRING)
    private Genre moviegenre;

    @ManyToMany
    private List<Location> location = new ArrayList<>();

    public WalkingTour() {
    }

    public WalkingTour(String name,int price, String description,Genre genre) {
        this.price = price;
        this.description = description;
        this.moviegenre = genre;
        this.tourname = name;
    }

    public void addLocation(Location location){
        this.location.add(location);
    }

    public void addTimeslot(Timeslot timeslot){
        this.timeslot=timeslot;
    }

    public void addMovie(Movie movie){
        this.movies.add(movie);
    }

    public long getId() {
        return id;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public List<Location> getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "WalkingTour{" +
                "id=" + id +
                ", movies=" + movies +
                ", timeslot=" + timeslot +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", location=" + location +
                '}';
    }
}
