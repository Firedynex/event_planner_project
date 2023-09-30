package event_planner.api;

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

  private ApiCaller() {
    getNinjaKey();
  }

  public String getCurrency(String eventCountry) {
    String countryUrl = "https://api.api-ninjas.com/v1/country?name=" + eventCountry;
    HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create(countryUrl))
    .header("X_API_KEY", ninjaKey)
    .GET()
    .build();

    try {
      HttpResponse<String> response = HTTP_CLIENT.send(request, BodyHandlers.ofString());
      String responseBody = response.body();
      Country[] country = GSON.<Country[]>fromJson(responseBody, Country[].class);
      return country[0].getCurrency();
    } catch (Throwable e) {
      throw new IllegalArgumentException("Invalid Country");
    }
  }

  private getNinjaKey() {
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