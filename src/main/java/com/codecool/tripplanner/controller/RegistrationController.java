package com.codecool.tripplanner.controller;

import com.codecool.tripplanner.jbcrypt.BCrypt;
import com.codecool.tripplanner.module.TripUser;
import com.codecool.tripplanner.repository.TripUserRepo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

@RestController
@CrossOrigin
public class RegistrationController {

    private TripUserRepo tripUserRepo;

    public RegistrationController(TripUserRepo tripUserRepo){
        this.tripUserRepo = tripUserRepo;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException{

        // Parse request
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>() {
        }.getType();
        Map<String, String> registrationData = gson.fromJson(request.getReader(), type);

        // Create user
        String email = registrationData.get("email");
        String password = registrationData.get("password1");
        String hashedPassword = DatatypeConverter.printBase64Binary(password.getBytes());
        //String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        TripUser user = new TripUser(email, hashedPassword);
        tripUserRepo.save(user);
        System.out.println("The user added with this e-mail:   " + email);

    }

}
