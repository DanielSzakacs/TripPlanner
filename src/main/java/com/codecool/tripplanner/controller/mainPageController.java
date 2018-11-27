package com.codecool.tripplanner.controller;

import com.codecool.tripplanner.enums.CityName;
import com.codecool.tripplanner.enums.Genre;
import com.codecool.tripplanner.module.WalkingTour;
import com.codecool.tripplanner.repository.WalkingTourRepo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/data")
    public List<WalkingTour> findAll(){
        return walkingTourRepo.findAll();
    }

    @PostMapping("/search")
    public List<WalkingTour> search(HttpServletRequest request) throws IOException {
        System.out.println("This is the request " + request);
        System.out.println("THIS IIIIII " + request.getInputStream().toString());

        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>() {
        }.getType();
        System.out.println(type.toString());
        Map<String, String> searchdata = gson.fromJson(request.getReader(), type);
        System.out.println(searchdata.get("city"));
        System.out.println(searchdata.get("genre"));

        System.out.println("CITYYY " + searchdata.get("city"));
        System.out.println("GENREEEE " + searchdata.get("genre"));
        //CityName cityName = CityName.valueOf(city);
        //Genre genre1 = Genre.valueOf(genre);
        //return walkingTourRepo.findAllByCityNameAndMoviegenre(cityName,genre1);
        return null;

    }

}
