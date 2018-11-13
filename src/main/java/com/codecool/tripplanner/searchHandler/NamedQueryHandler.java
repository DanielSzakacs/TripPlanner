package com.codecool.tripplanner.searchHandler;

import com.codecool.tripplanner.JPA;
import com.codecool.tripplanner.enums.CityName;
import com.codecool.tripplanner.enums.Genre;
import com.codecool.tripplanner.moduls.WalkingTour;

import java.util.List;

public class NamedQueryHandler {

    public List<WalkingTour> getAllWalkingTour(String city, String genre){
        CityName enumCityName = CityName.valueOf(city);
         Genre enumGenre = Genre.valueOf(genre);
        List<WalkingTour> result = JPA.getEntityManager()
                .createNamedQuery("Walkingtour.getAllWalkingtour")
                .setParameter("cityName", enumCityName)
                .setParameter("walkingtourgenre", enumGenre)
                .getResultList();
        //List<WalkingTour> result = JPA.getEntityManager().createNamedQuery("Walkingtour.getAllWalkingtourByLocation").setParameter("cityName", enumCityName).getResultList();
        return result;
    }

}
