package corinth.event_planner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.URI;
import java.net.URLEncoder;

import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ApiCaller {
    
    private String ninjaKey;

    /** HTTP client. */
    private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder()
        .version(HttpClient.Version.HTTP_2)           // uses HTTP protocol version 2 where possible
        .followRedirects(HttpClient.Redirect.NORMAL)  // always redirects, except from HTTPS to HTTP
        .build();                                     // builds and returns a HttpClient object

    /** Google {@code Gson} object for parsing JSON-formatted strings. */
    private static Gson GSON = new GsonBuilder()
        .setPrettyPrinting()                          // enable nice output when printing
        .create();                                    // builds and returns a Gson object

        /** Constructor that initializes the instance variables. */
    public ApiCaller() {
        getKey();
    }

    /**
     * Gets the host country and stores it in {@code hostCountry}
     * for easy access.
     * @param hostCountry The country to look up.
     * @return Country Host country information.
     */
    public Country getCountry(String hostCountry) {
        String url = "https://api.api-ninjas.com/v1/country?name=";
        try {
            String countryName = URLEncoder.encode(hostCountry, StandardCharsets.UTF_8);
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + countryName))
                .header("X-API-KEY", ninjaKey)
                .build();
            HttpResponse<String> response = HTTP_CLIENT.send(request, BodyHandlers.ofString());
            String responseBody = response.body();
            Country[] country = GSON.<Country[]>fromJson(responseBody, Country[].class);
            return country[0];
        } catch (Throwable e) {
            throw new IllegalArgumentException("The given country is invalid!");
        }
    }

    /**
     * Method that returns a city object that holds data about a city.
     * @param city Name of the host city.
     * @return City Object of the host city.
     */
    public City getCity(String city) {
        String url = "https://api.api-ninjas.com/v1/city?name=";
        try {
            String cityName = URLEncoder.encode(city, StandardCharsets.UTF_8);
            HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url + cityName))
            .header("X-API-Key", ninjaKey)
            .build();
            HttpResponse<String> response = HTTP_CLIENT.send(request, BodyHandlers.ofString());
            String responseBody = response.body();
            City[] hostCity = GSON.<City[]>fromJson(responseBody, City[].class);
            return hostCity[0];
        } catch (Throwable e) {
            throw new IllegalArgumentException("The given city is not valid!");
        }
    }
    /**
     * Method that gets the API Key.
     */
    private void getKey() {
        try {
            Properties props = new Properties();
            BufferedInputStream apiKeyFile = new BufferedInputStream(new FileInputStream("D:\\Coding Projects\\Private_Keys.properties"));
            props.load(apiKeyFile);
            ninjaKey = props.getProperty("API_NINJAS_KEY");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
