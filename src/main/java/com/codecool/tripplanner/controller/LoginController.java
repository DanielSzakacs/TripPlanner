package com.codecool.tripplanner.controller;

import com.codecool.tripplanner.module.TripUser;
import com.codecool.tripplanner.repository.TripUserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@RestController
@CrossOrigin
public class LoginController {

    private TripUserRepo tripUserRepo;

    public LoginController(TripUserRepo tripUserRepo){
        this.tripUserRepo = tripUserRepo;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public HttpStatus login(HttpServletRequest request) throws IOException{
        HttpSession session = request.getSession();

        // Specifies the time, in seconds, between client requests
        // before the servlet container will invalidate this session.
        session.setMaxInactiveInterval(120 * 60);

        //https://stackoverflow.com/questions/43117731/what-is-type-typetoken
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>() { }.getType();
        Map<String, String> loginData = gson.fromJson(request.getReader() , type);

        String email = loginData.get("email");
        String password = loginData.get("password");

        //Get the user from DB
        HttpStatus resultMessage;
        TripUser user = tripUserRepo.findtripUserByEmail(email);
        if(user == null){
            resultMessage = HttpStatus.valueOf(401); //401 means = Unauthorized
            System.out.println(resultMessage);
            return resultMessage;
        }

        if(user != null){
            resultMessage = HttpStatus.valueOf(200);
        }

        //Need verify user, waiting for the registration



        return null;
    }


}
