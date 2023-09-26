package event_planner;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.URI;
import java.net.URLEncoder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.nio.charset.StandardCharsets;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;



/**
 * This class is meant to help get the weather forecast for an area.
 */
public class Weather {
    
    private static Gson GSON = new GsonBuilder()
    .setPrettyPrinting()
    .create();
    
    private static HttpClient HTTP_CLIENT = HttpClient.newBuilder()
    .version(HttpClient.Version.HTTP_2)
    .followRedirects(HttpClient.Redirect.NORMAL)
    .build();
    
    public Weather() {
        
    }
}
