package com.koterpillar.uvalert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Server location
 */

public class Server {
    private URL baseUrl;
    private URL locationsUrl;

    public Server(String baseUrl) throws MalformedURLException {
        this.baseUrl = new URL(baseUrl);
        this.locationsUrl = new URL(this.baseUrl, "/locations");
    }

    public URL getLocationsUrl() {
        return locationsUrl;
    }
}
