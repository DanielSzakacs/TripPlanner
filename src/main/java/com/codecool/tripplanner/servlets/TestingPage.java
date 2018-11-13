package com.codecool.tripplanner.servlets;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import javax.json.Json;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


@WebServlet(name = "TestingPage", urlPatterns = {"/data"})
@MultipartConfig
public class TestingPage extends HttpServlet {

    private final String jsonData;

    public TestingPage (String jsonData){
        this.jsonData = jsonData;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String jsonData = Json.createObjectBuilder()
                .add("name", "Daniel")
                .add("location", "Ukraine")
                .build()
                .toString();


        response.setContentType("application/json");
        response.getWriter().print(jsonData);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = "";
        if(br != null){
            json = br.readLine();
        }
//        System.out.println(json);


//        JSONObject obj = null;
        try {
            JSONObject obj = new JSONObject(json);
            String name = obj.getString("name");
            String location = obj.getString("location");

//            System.out.println(name);

//            JSONArray arr = obj.getJSONArray("posts");
//            for (int i = 0; i < arr.length(); i++) {
//                String post_id = arr.getJSONObject(i).getString("post_id");
//                System.out.println(post_id);
//            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}