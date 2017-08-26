package com.koterpillar.uvalert;

import android.os.AsyncTask;
import android.util.JsonReader;

import org.json.JSONArray;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Get locations from the server.
 */

public abstract class GetLocations extends AsyncTask<URL, Integer, List<Location>> {
    @Override
    protected List<Location> doInBackground(URL... params) {
        try {
            HttpURLConnection connection = (HttpURLConnection) params[0].openConnection();
            InputStream in = new BufferedInputStream(connection.getInputStream());
            JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
            reader.beginArray();
            ArrayList<Location> result = new ArrayList<Location>();
            while (reader.hasNext()) {
                result.add(Location.read(reader));
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<Location>();
        }
    }
}
