package event_planner;

import java.net.http.HttpClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Event_Getter {

  private static Gson GSON = new GsonBuilder()
      .setPrettyPrinting()
      .create();

  private static HttpClient HTTP_CLIENT = HttpClient.newBuilder()
      .version(HttpClient.Version.HTTP_2)
      .followRedirects(HttpClient.Redirect.NORMAL)
      .build();


}
