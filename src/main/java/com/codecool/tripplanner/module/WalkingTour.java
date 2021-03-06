package com.codecool.tripplanner.module;

import com.codecool.tripplanner.enums.CityName;
import com.codecool.tripplanner.enums.Genre;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@NamedQueries({
    @NamedQuery(name = "displayalltour",query = "SELECT w from WalkingTour w"),
    @NamedQuery(name = "Walkingtour.getAllWalkingtour",
            query = "SELECT s FROM WalkingTour s WHERE " +
            "(s.moviegenre = :walkingtourgenre OR :walkingtourgenre IS NULL OR :walkingtourgenre = '') AND " +
            "(s.cityName = :cityName OR :cityName IS NULL or :cityName = '')" )
})
public class WalkingTour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany
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

    @Enumerated(value = EnumType.STRING)
    private CityName cityName;

    @ManyToMany
    private List<Location> locations = new ArrayList<>();



    public WalkingTour() {
    }

    public WalkingTour(String name,int price, String description,Genre genre,CityName cityName) {
        this.price = price;
        this.description = description;
        this.moviegenre = genre;

        this.tourname = name;
        this.cityName = cityName;
    }

    public void addLocation(Location location){
        this.locations.add(location);
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

    public List<Location> getLocations() {
        return locations;
    }

    @Override
    public String toString() {
        return "WalkingTour{" +
                "id=" + id +
                ", movies=" + movies +
                ", timeslot=" + timeslot +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", location=" + locations +
                '}';
    }
}
