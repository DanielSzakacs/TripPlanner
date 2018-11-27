//package com.codecool.tripplanner.controller;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//@WebServlet(name = "SingUpServlet", urlPatterns = {"/sing_up"})
//@MultipartConfig
//public class SinUpServlet extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        NamedQueryHandler nqh = new NamedQueryHandler();
//        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
//        String json = (br != null) ? br.readLine() : null;
//        JSONObject userData = null;
//        try {
//            userData = new JSONObject(json);
//            System.out.println(userData);
//            nqh.saveUserData(userData.getString("email"), userData.getString("password1") );
//        } catch (JSONException e) {
//            e.printStackTrace();
//            System.out.println("THIS IS A BIG PROBLEM");
//        }
//
//    }
//}
