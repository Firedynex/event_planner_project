package corinth.event_planner;

/**
 * Class for the current weather conditions for a given city.
 */
public class Weather {
    private double cloud_pct;
    private double temp;
    private double feels_like;
    private double humidity;
    private double min_temp;
    private double max_temp;
    private double wind_speed;
    private double wind_degrees;
    private int sunrise;
    private int sunset;

    /**
     * Accessor method for cloud percentage.
     * @return double Current percent chance of clouds.
     */
    public double getCloudPct() {
        return this.cloud_pct;
    }

    /**
     * Accessor method for temperature.
     * @return double Current temperature.
     */
    public double getTemp() {
        return this.temp;
    }

    /**
     * Gets the current feels like temperature.
     * @return double Current feels like temperature.
     */
    public double getFeelsLike() {
        return this.feels_like;
    }

    /**
     * Gets the current humidity.
     * @return double Current humidity of the city.
     */
    public double getHumidity() {
        return this.humidity;
    }

    /**
     * Gets the minimum temperature of the day.
     * @return double Minimum temperature for the day.
     */
    public double getMintemp() {
        return this.min_temp;
    }

    /**
     * Gets the maximum temperature of the day.
     * @return double Maximum temperature for the day.
     */
    public double getMaxTemp() {
        return this.max_temp;
    }

    /**
     * Gets the current wind status.
     * @return double Current wind status.
     */
    public double getWindDegrees() {
        return this.wind_degrees;
    }

    /**
     * Gets the current wind speed.
     * @return doube Current wind speed.
     */
    public double getWindSpeed() {
        return this.wind_speed;     
    }

    /**
     * Gets the daily expected sunrise time in epoch unix timestamp.
     * @return double Current expected sunrise time in epoch unix timestamp.
     */
    public int getSunrise() {
        return this.sunrise;
    }

    /**
     * Gets the daily expected sunset time in epoch unix timestamp.
     * @return double Current expected sunset time in epoch unix timestamp.
     */
    public int getSunset(){
        return this.sunset;
    }
}
