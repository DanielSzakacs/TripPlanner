package com.codecool.tripplanner.controller;

import com.codecool.tripplanner.enums.CityName;
import com.codecool.tripplanner.enums.Genre;
import com.codecool.tripplanner.module.Timeslot;
import com.codecool.tripplanner.module.TripUser;
import com.codecool.tripplanner.module.WalkingTour;
import com.codecool.tripplanner.repository.TimeslotRepo;
import com.codecool.tripplanner.repository.TripUserRepo;
import com.codecool.tripplanner.repository.WalkingTourRepo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class mainPageController {

    @Autowired
    private WalkingTourRepo walkingTourRepo;

    @Autowired
    private TripUserRepo tripUserRepo;

    @Autowired
    private LoginController loginController;

    @Autowired
    private TimeslotRepo timeslotRepo;

    @GetMapping("/data")
    public List<WalkingTour> findAll(){
        return walkingTourRepo.findAll();
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public List<WalkingTour> search(HttpServletRequest request) throws IOException {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>() {}.getType();
        Map<String, String> searchdata = gson.fromJson(request.getReader(), type);

        CityName cityName = CityName.valueOf(searchdata.get("city"));
        Genre genre1 = Genre.valueOf(searchdata.get("genre"));
        return walkingTourRepo.findAllByCityNameAndMoviegenre(cityName,genre1);
    }

    @RequestMapping(value = "/savebooking", method = RequestMethod.POST)
    public void saveTheBooking(HttpServletRequest request) throws IOException {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>() {}.getType();
        Map<String, String> bookingData = gson.fromJson(request.getReader(), type);

        HttpSession userInSession = loginController.getSession();
        String userId = userInSession.getId();

        TripUser user = tripUserRepo.findFirstById(userId);

        // id, visitDate

        String tripId = bookingData.get("id");
        String visitDate = bookingData.get("visitDate");

        Timeslot booked = new Timeslot(walkingTourRepo.getFirstById(tripId), visitDate);
        user.addToTimeSlot(booked);

        timeslotRepo.save(booked);
        System.out.println("The walking tour book was successful");

    }

}
