package com.codecool.tripplanner.controller;

import com.codecool.tripplanner.jbcrypt.BCrypt;
import com.codecool.tripplanner.module.TripUser;
import com.codecool.tripplanner.repository.TripUserRepo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import javax.servlet.http.HttpServletResponse;
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
    public HttpStatus register(HttpServletRequest request, HttpServletResponse response) throws IOException{

        // Parse request
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>() {
        }.getType();
        Map<String, String> registrationData = gson.fromJson(request.getReader(), type);

        // Create user
        String email = registrationData.get("email");
        String password1 = registrationData.get("password1");
        String password2 = registrationData.get("password2");

        HttpStatus resultMessage;

        if(password1.equals(password2)){
            String hashedPassword = BCrypt.hashpw(password1, BCrypt.gensalt());
            TripUser user = new TripUser(email, hashedPassword);
            tripUserRepo.save(user);
            System.out.println("The user added with this e-mail:   " + email);
            response.setStatus(200);
            resultMessage = HttpStatus.resolve(200);

        }else{
            System.out.println("The passwords doesn't matches!");
            //resultMessage = HttpStatus.resolve(401);
            response.setStatus(401);

        }return null;

    }

}
