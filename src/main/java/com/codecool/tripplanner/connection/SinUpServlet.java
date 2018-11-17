package com.codecool.tripplanner.connection;

import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@WebServlet(name = "SingUpServlet", urlPatterns = {"/sing_up"})
@MultipartConfig
public class SinUpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = (br != null) ? br.readLine() : null;
        try {
            JSONObject userData = new JSONObject(json);

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
