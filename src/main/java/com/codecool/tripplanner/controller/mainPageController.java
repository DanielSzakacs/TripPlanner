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
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public List<WalkingTour> search(HttpServletRequest request) throws IOException {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>() {}.getType();
        Map<String, String> searchdata = gson.fromJson(request.getReader(), type);

        CityName cityName = CityName.valueOf(searchdata.get("city"));
        Genre genre1 = Genre.valueOf(searchdata.get("genre"));
        return walkingTourRepo.findAllByCityNameAndMoviegenre(cityName,genre1);
    }

}
