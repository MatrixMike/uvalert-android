package com.koterpillar.uvalert;

import android.util.JsonReader;

import java.io.IOException;

/**
 * Location that has alerts.
 */

public class Location {
    private String id;

    private String country;
    private String region;
    private String city;

    public Location(String id, String country, String region, String city) {
        this.id = id;
        this.country = country;
        this.region = region;
        this.city = city;
    }

    @Override
    public String toString() {
        return country + ", " + region + ", " + city;
    }

    public String getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }

    public static Location read(JsonReader reader) throws IOException {
        String id = null;
        String country = null;
        String region = null;
        String city = null;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            switch (name) {
                case "id":
                    id = reader.nextString();
                    break;
                case "country":
                    country = reader.nextString();
                    break;
                case "region":
                    region = reader.nextString();
                    break;
                case "city":
                    city = reader.nextString();
                    break;
                default:
                    reader.skipValue();
            }
        }

        reader.endObject();
        return new Location(id, country, region, city);
    }
}
