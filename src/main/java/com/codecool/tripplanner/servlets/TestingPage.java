package com.codecool.tripplanner.servlets;
import com.codecool.tripplanner.JPA;
import com.codecool.tripplanner.config.TemplateEngineUtil;
import com.codecool.tripplanner.moduls.WalkingTour;
import com.codecool.tripplanner.searchHandler.NamedQueryHandler;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.json.JSONException;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet(name = "TestingPage", urlPatterns = {"/data"})
@MultipartConfig
public class TestingPage extends HttpServlet {

    private String jsonTourData;

    public TestingPage (){
        this.jsonTourData = createJSON();
    }

    private Map<String,HashMap> createToursForJSON() {
        HashMap<String,HashMap> hashTours = new HashMap<>();
        HashMap<String,String> walkingTour = new HashMap<>();
        List<WalkingTour> tours = JPA.getEntityManager().createNamedQuery("displayalltour").getResultList();

        for (int i = 0; i < tours.size(); i++) {
            walkingTour.put("price",Integer.toString(tours.get(i).getPrice()));
            walkingTour.put("tourname",tours.get(i).getTourname());
            walkingTour.put("description",tours.get(i).getDescription());
            //walkingTour.add(tours.get(i).getLocations().toString());
            HashMap<String,String> newArrayList = (HashMap<String, String>) walkingTour.clone();
            hashTours.put("walkingtour" + Integer.toString(i),newArrayList);
            walkingTour.clear();
        }
        return hashTours;
    }

    private String createJSON(){
        return new Gson().toJson(createToursForJSON());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        response.getWriter().print(jsonTourData);
//        PrintWriter out = response.getWriter();
//        out.print(jsonTourData);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = "";
        if(br != null){
            json = br.readLine();
        }
//        System.out.println(json);



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
