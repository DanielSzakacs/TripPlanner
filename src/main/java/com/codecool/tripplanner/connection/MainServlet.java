/*package com.codecool.tripplanner.controller;
import com.codecool.tripplanner.DAO.JPA;
import com.codecool.tripplanner.module.WalkingTour;
import com.codecool.tripplanner.DAO.NamedQueryHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "MainServlet", urlPatterns = {"/data"}) // strange name call it tours of something
@MultipartConfig
public class MainServlet extends HttpServlet {

    private JSONArray createHashMap(List<WalkingTour> walkingTours) throws JSONException {

        List<WalkingTour> tours = walkingTours;
        JSONArray jsonArray = new JSONArray();

        for (int i = 0; i < tours.size(); i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("price",Integer.toString(tours.get(i).getPrice()));
            jsonObject.put("tourname",tours.get(i).getTourname());
            jsonObject.put("description",tours.get(i).getDescription());
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        try {
            response.getWriter().print(createHashMap(JPA.getEntityManager().createNamedQuery("displayalltour").getResultList()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = "";
        if(br != null){
            json = br.readLine();
        }
        String city = "";
        String genre = "";

        try {
            JSONObject data = new JSONObject(json);
            city = data.getJSONObject("data").getString("city");
            genre = data.getJSONObject("data").getString("genre");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        NamedQueryHandler nqh  = new NamedQueryHandler();

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        try {
            out.print(createHashMap(nqh.getAllWalkingTour(city,genre)));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}