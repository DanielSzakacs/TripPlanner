package com.codecool.tripplanner.searchHandler;

import com.codecool.tripplanner.JPA;
import com.codecool.tripplanner.enums.CityName;
import com.codecool.tripplanner.enums.Genre;
import com.codecool.tripplanner.moduls.Movie;
import com.codecool.tripplanner.moduls.WalkingTour;

import java.util.List;

public class namedQueryHandler {

    public List<WalkingTour> getAllWalkingTourByCityName(String city){
        CityName enumCityName = CityName.valueOf(city);
        List<WalkingTour> result = JPA.getEntityManager().createNamedQuery("Location.getAllWalkingtour").setParameter("cityname", enumCityName).getResultList();
        return result;
    }

    public List<WalkingTour> getAllWalkingTourByGenre(String genre){
        Genre movieGenre = Genre.valueOf(genre);
        List<WalkingTour> result = JPA.getEntityManager().createNamedQuery("Walkingtour.getAllWalkingtourByGenre").setParameter("walkingtourgenre", movieGenre).getResultList();
        return result;
    }
}
