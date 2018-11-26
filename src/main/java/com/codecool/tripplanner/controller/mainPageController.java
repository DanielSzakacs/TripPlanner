package com.codecool.tripplanner.controller;

import com.codecool.tripplanner.module.WalkingTour;
import com.codecool.tripplanner.repository.WalkingTourRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class mainPageController {

    @Autowired
    private WalkingTourRepo walkingTourRepo;

    @GetMapping("/data")
    public List<WalkingTour> findAll(){
        return walkingTourRepo.findAll();
    }
}
