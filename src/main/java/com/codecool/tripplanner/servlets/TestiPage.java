package com.codecool.tripplanner.servlets;
import com.codecool.tripplanner.JPA;
import com.codecool.tripplanner.config.TemplateEngineUtil;
import com.codecool.tripplanner.moduls.WalkingTour;
import com.codecool.tripplanner.searchHandler.NamedQueryHandler;
import com.google.gson.Gson;
import org.json.JSONException;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;


import javax.json.Json;
import org.json.JSONObject;

import javax.json.JsonObject;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@WebServlet(name = "TestingPage", urlPatterns = {"/data"})
@MultipartConfig
public class TestiPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HashMap<String,List> Hashtours = new HashMap<>();
        List<String> walkingtour = new ArrayList<>();
        List<WalkingTour> tours = JPA.getEntityManager().createNamedQuery("displayalltour").getResultList();

        for (int i = 0; i < tours.size(); i++) {
            walkingtour.add(Integer.toString(tours.get(i).getPrice()));
            walkingtour.add(tours.get(i).getTourname());
            walkingtour.add(tours.get(i).getDescription());
            //walkingtour.add(tours.get(i).getLocations().toString());
            List newArrayList = (ArrayList) ((ArrayList<String>) walkingtour).clone();
            Hashtours.put("walkingtour" + Integer.toString(i),newArrayList);
            walkingtour.clear();
        }

        String jsonTourData = new Gson().toJson(Hashtours);



        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(jsonTourData);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = "";
        if(br != null){
            json = br.readLine();
        }
        System.out.println(json);


        String city = "";
        String genre = "";

        try {
            JSONObject data = new JSONObject(json);
            city = data.getJSONObject("data").getString("city");
            genre = data.getJSONObject("data").getString("genre");
        } catch (JSONException e) {
            e.printStackTrace();
        }



        TemplateEngine engine = TemplateEngineUtil. getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());
        NamedQueryHandler nqh  = new NamedQueryHandler();



        context.setVariable("tours", nqh.getAllWalkingTour(city,genre));
        engine.process("agency/index.html", context, response.getWriter());

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(nqh.getAllWalkingTour(city,genre));



    }
}