package com.codecool.tripplanner.controller;

import com.codecool.tripplanner.jbcrypt.BCrypt;
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

@CrossOrigin
@RestController
public class LoginController {

    private TripUserRepo tripUserRepo;

    private HttpSession session;

    public LoginController(TripUserRepo tripUserRepo, HttpSession session){
        this.tripUserRepo = tripUserRepo;
        this.session = session;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public HttpStatus login(HttpServletRequest request) throws IOException{
        this.session = request.getSession();

        // Specifies the time, in seconds, between client requests
        // before the servlet container will invalidate this session.
        session.setMaxInactiveInterval(120 * 60);

        //https://stackoverflow.com/questions/43117731/what-is-type-typetoken
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>() { }.getType();
        Map<String, String> loginData = gson.fromJson(request.getReader() , type);

        String email = loginData.get("email");
        System.out.println("email: " + email);
        String password = loginData.get("password");

        //Get the user from DB
        HttpStatus resultMessage;
        TripUser user = tripUserRepo.findTripUserByUsername(email);
        if(user == null){
            resultMessage = HttpStatus.valueOf(401); //401 means = Unauthorized
            System.out.println(resultMessage);
            return resultMessage;
        }

        //Check the password
        if(BCrypt.checkpw(password, user.getPassword())){
            session.setAttribute("user",user);
            resultMessage = HttpStatus.valueOf(200); // 200 means = OK
        }else{
            resultMessage = HttpStatus.valueOf(401);
        }
        return resultMessage;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public boolean checkUserInTheSession(){
        if(session.getAttribute("user") == null){
            return true;
        }else{
            return false;
        }
    }


}
