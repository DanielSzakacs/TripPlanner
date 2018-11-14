package com.codecool.tripplanner.servlets;
import com.codecool.tripplanner.JPA;
import com.codecool.tripplanner.moduls.WalkingTour;
import com.codecool.tripplanner.searchHandler.NamedQueryHandler;
import com.google.gson.Gson;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


@WebServlet(name = "TestingPage", urlPatterns = {"/data"})
@MultipartConfig
public class TestingPage extends HttpServlet {


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


//        TemplateEngine engine = TemplateEngineUtil. getTemplateEngine(request.getServletContext());
//        WebContext context = new WebContext(request, response, request.getServletContext());
        NamedQueryHandler nqh  = new NamedQueryHandler();

        //context.setVariable("tours", nqh.getAllWalkingTour(city,genre));
        //engine.process("agency/index.html", context, response.getWriter());

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        try {
            out.print(createHashMap(nqh.getAllWalkingTour(city,genre)));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}