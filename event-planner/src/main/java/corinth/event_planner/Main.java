package corinth.event_planner;

public class Main {
    public static void main(String[] args) {
        ApiCaller apiCaller = new ApiCaller();
        WeeklyWeather[] weather = apiCaller.weeklyWeather(52.52, 13.41);
        for (int i = 0; i < 7; i++) {
            System.out.println(weather[i].getTime());
        }
    }
}
