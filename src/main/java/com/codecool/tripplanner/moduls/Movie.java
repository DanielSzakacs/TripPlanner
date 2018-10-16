package com.codecool.tripplanner.moduls;

import com.codecool.tripplanner.enums.Genre;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    private List<Actor> actors = new ArrayList<>();
    private List<Location> locations = new ArrayList<>();
    private String name;
    private Genre genre;
}
