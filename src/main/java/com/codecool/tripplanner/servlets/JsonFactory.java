package com.codecool.tripplanner.servlets;

import com.codecool.tripplanner.moduls.WalkingTour;
import com.codecool.tripplanner.searchHandler.NamedQueryHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class JsonFactory {

    public JSONArray createHashMap(List<WalkingTour> walkingTours) throws JSONException {

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
}
