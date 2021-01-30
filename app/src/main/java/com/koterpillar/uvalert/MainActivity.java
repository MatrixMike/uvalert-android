package com.koterpillar.uvalert;

import android.os.Bundle;
// import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.net.MalformedURLException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static Server server;

@Override   // // mjh
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            this.server = new Server("https://uvalert.koterpillar.com");
        } catch (MalformedURLException e) {
            this.server = null;
        }

        final MainActivity self = this;

        final Spinner locationSpinner = (Spinner) findViewById(R.id.location);   // mjh
        locationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // TODO
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // TODO
            }
        });

        new  GetLocations() {
            @Override
            protected void onPostExecute(List<Location> locations) {
                super.onPostExecute(locations);
                ArrayAdapter<Location> adapter = new ArrayAdapter<>(self, android.R.layout.simple_spinner_item, locations);
                locationSpinner.setAdapter(adapter);
            }
        }.execute(server.getLocationsUrl());
    }

}
