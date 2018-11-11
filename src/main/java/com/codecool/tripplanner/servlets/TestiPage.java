package com.codecool.tripplanner.servlets;
import org.apache.logging.log4j.core.jackson.Log4jJsonObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import javax.json.Json;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.io.IOException;
import java.util.Map;


@WebServlet(name = "TestingPage", urlPatterns = {"/data"})
@MultipartConfig
public class TestiPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String jsonData = Json.createObjectBuilder()
                .add("name", "Daniel")
                .add("location", "Ukraine")
                .build()
                .toString();


//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, HEAD, OPTIONS");
//        response.setHeader("Access-Control-Allow-Headers", "Origin, Accept, x-auth-token, "
//                + "Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(jsonData);
        //out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, HEAD, OPTIONS");
//        response.setHeader("Access-Control-Allow-Headers", "Origin, Accept, x-auth-token, "
//                + "Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");

        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = "";
        if(br != null){
            json = br.readLine();
        }
        System.out.println(json);


    }

//    public void getSomthingFromAJson(){
//        ObjectMapper mapper = new ObjectMapper();
//        Map<String, String> mappedJsonData = objectMapper.re
//    }
}