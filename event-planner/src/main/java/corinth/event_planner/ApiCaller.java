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

import org.apache.http.HttpException;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ApiCaller {
    
    private String ninjaKey;
    private String newsKey;

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
        getKey("D:\\Coding Projects\\Private_Keys.properties", "API_NINJAS_KEY", ninjaKey);
        getKey("D:\\Coding Projects\\Private_Keys.properties", "GUARDIAN_KEY", newsKey);
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
            .header("X-API-Key", this.ninjaKey)
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
     * Method that returns a weather object with detailed description about the current
     * weather status of a given city.
     * @param city Name of the desired city
     * @param country Name of the desired country where city resides
     * @return Weather Object that contains information about the current weather conditions.
     * @throws HttpException Throws in case API fails.
     */
    public Weather getWeather(String city, String country) throws HttpException {
        String url = "https://api.api-ninjas.com/v1/weather?city=";
        try {
            String cityName = URLEncoder.encode(city, StandardCharsets.UTF_8);
            HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url + cityName))
            .header("X-API-Key", this.ninjaKey)
            .build();
            HttpResponse<String> response = HTTP_CLIENT.send(request, BodyHandlers.ofString());
            String responseBody = response.body();
            Weather weather = GSON.<Weather>fromJson(responseBody, Weather.class);
            return weather;
        } catch (Throwable e) {
            throw new HttpException("Failed to retrieve information");
        }
    }
    /**
     * Returns a news object that contains 10 stories for the given {@code location}.
     * @param location The location of the event.
     * @return News {@code News} object that contains and array of 10 relevant stories.
     */
    public News getNews(String location) {
        String url = "https://content.guardianapis.com/search?q=";
        String apiKey = "&api-key=" + newsKey;
        try {
            String query = URLEncoder.encode(location, StandardCharsets.UTF_8);
            HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url + query + apiKey))
            .build();
            HttpResponse<String> response = HTTP_CLIENT.send(request, BodyHandlers.ofString());
            String responseBody = response.body();
            News newsObject = GSON.<News>fromJson(responseBody, News.class);
            return newsObject;
        } catch (Throwable e) {
            throw new IllegalStateException("Couldn't get news from the given query!");
        }
    }

    public Forecast.weather[] weeklyWeather(double latitude, double longitude) {
        String url = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude +
        "&daily=temperature_2m_max,temperature_2m_min,sunrise,sunset,uv_index_max,uv_index_clear_sky_max,precipitation_probability_max,wind_speed_10m_max&temperature_unit=fahrenheit&timezone=America%2FNew_York";
        try {
            HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();
            HttpResponse<String> response = HTTP_CLIENT.send(request, BodyHandlers.ofString());
            String responseBody = response.body();
            Forecast.daily dailyForecast = GSON.<Forecast.daily>fromJson(responseBody, Forecast.daily.class);
            Forecast forecast = new Forecast();
            return forecast.populate(dailyForecast);
        } catch (Throwable e) {
            throw new IllegalStateException("Couldn't get the weather forecast!");
        }
    }
    /**
     * Method that gets API keys.
     * @param fileLocation Location of the file on the drive.
     * @param keyName Name of the key for a specific API.
     */
    private void getKey(String fileLocation, String keyName, String apiKey) {
        try {
            Properties props = new Properties();
            BufferedInputStream apiKeyFile = new BufferedInputStream(new FileInputStream(fileLocation));
            props.load(apiKeyFile);
            apiKey = props.getProperty(keyName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}