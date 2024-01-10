package corinth.event_planner;

public class Forecast {

    public class Daily {
        private String[] time;
        private double[] temperature_2m_max;
        private double[] temperature_2m_min;
        private String[] sunrise;
        private String[] sunset;
        private double[] uv_index_max;
        private double[] uv_index_clear_sky_max;
        private double[] precipitation_probability_max;
        private double[] wind_speed_10m_max;

        /**
         * Accessor method for the time array.
         * @return String[] String array that contains the week.
         */
        public String[] getTime() {
            return time;
        }

        /**
         * Accessor method for the max temperature array.
         * @return double[] Array that contains all of the max temps. for the week.
         */
        public double[] getTemperature_2m_max() {
            return temperature_2m_max;
        }

        /**
         * Accessor method for the min temperature array.
         * @return double[] Array that contains all of the min temps. for the week.
         */
        public double[] getTemperature_2m_min() {
            return temperature_2m_min;
        }

        /**
         * Accessor method for the sunrise times for each day.
         * @return String[] String array that contains the sunrise times for each day.
         */
        public String[] getSunrise() {
            return sunrise;
        }

        /**
         * Accessor method for the sunset times for each day.
         * @return String[] String array that contains the sunset times for each day.
         */
        public String[] getSunset() {
            return sunset;
        }

        /**
         * Accessor method for the max UV index for each day.
         * @return double[] Array that contains the max UV index for each day.
         */
        public double[] getUv_index_max() {
            return uv_index_max;
        }

        /**
         * Accessor method for the clear sky UV index for each day.
         * @return double[] Array that contains the max UV index for a clear sky for each day.
         */
        public double[] getUv_index_clear_sky_max() {
            return uv_index_clear_sky_max;
        }

        /**
         * Accessor method for the maximum probability of precipitation for each day.
         * @return double[] Array that contains the maximum precipitation probability for each day.
         */
        public double[] getPrecipitation_probability_max() {
            return precipitation_probability_max;
        }

        /**
         * Accessor method for the maximum wind speed for each day.
         * @return double[] Array that contains the maximum wind speed for each day.
         */
        public double[] getWind_speed_10m_max() {
            return wind_speed_10m_max;
        }
    }

    private Daily daily;
    private WeeklyWeather[] forecast;

    /**
     * Constructor to create a new forecast object.
     */
    public Forecast() {
        this.forecast = new WeeklyWeather[7];
    }

    /**
     * Accessor method to get the forecast array.
     * @return weather[] Array that contains the forecast for the next 7 days.
     */
    public WeeklyWeather[] getForecast() {
        return this.forecast;
    }

    /**
     * Populates the {@code forecast} variable with weather objects representing the daily forecast for 
     * the next 7 days.
     * @param dailyForecast Daily object returned from a JSON object to get data from.
     * @return weather[] {@code forecast} array with populated weather objects.
     */
    public WeeklyWeather[] populate() {
        for (int i = 0; i < 7; i++) {
            WeeklyWeather weather = new WeeklyWeather();
            weather.setTime(this.daily.getTime()[i]);
            weather.setTemperature_2m_max(this.daily.getTemperature_2m_max()[i]);
            weather.setTemperature_2m_min(this.daily.getTemperature_2m_min()[i]);
            weather.setSunrise(this.daily.getSunrise()[i]);
            weather.setSunset(this.daily.getSunset()[i]);
            weather.setUv_index_max(this.daily.getUv_index_max()[i]);
            weather.setUv_index_clear_sky_max(this.daily.getUv_index_clear_sky_max()[i]);
            weather.setPrecipitation_probability_max(this.daily.getPrecipitation_probability_max()[i]);
            weather.setWind_speed_10m_max(this.daily.getWind_speed_10m_max()[i]);
            this.forecast[i] = weather;
        }
        return forecast;
    }
}
