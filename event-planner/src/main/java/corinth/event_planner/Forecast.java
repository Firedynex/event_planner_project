package corinth.event_planner;

public class Forecast {

    /**
     * Nested class that represents data for each day of the week for the next 7 days.
     */
    public class daily {
        String[] time;
        double[] temperature_2m_max;
        double[] temperature_2m_min;
        String[] sunrise;
        String[] sunset;
        double[] uv_index_max;
        double[] uv_index_clear_sky_max;
        double[] precipitation_probability_max;
        double[] wind_speed_10m_max;

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

    /**
     * Nested class that represents one day of the 7 day forecast.
     */
    private class weather {
        String time;
        double temperature_2m_max;
        double temperature_2m_min;
        String sunrise;
        String sunset;
        double uv_index_max;
        double uv_index_clear_sky_max;
        double precipitation_probability_max;
        double wind_speed_10m_max;

        /**
         * Accessor method to get the specific date.
         * @return String that represents the date.
         */
        public String getTime() {
            return time;
        }

        /**
         * Accessor method to get the maximum temperature of the day.
         * @return double that represents the maximum temperature of the day.
         */
        public double getTemperature_2m_max() {
            return temperature_2m_max;
        }

        /**
         * Accessor method to get the minimum temperature of the day.
         * @return double that represents the minimum temperature of the day.
         */
        public double getTemperature_2m_min() {
            return temperature_2m_min;
        }

        /**
         * Accessor method to get the sunrise time for the day.
         * @return String that represents the sunrise time.
         */
        public String getSunrise() {
            return sunrise;
        }

        /**
         * Accessor method to get the sunset time for the day.
         * @return String that represents the sunset time.
         */
        public String getSunset() {
            return sunset;
        }

        /**
         * Accessor method to get the maximum UV index of the day.
         * @return double that represents the maximum UV index of the day.
         */
        public double getUv_index_max() {
            return uv_index_max;
        }

        /**
         * Accessor method to get the maximum UV index for a clear sky.
         * @return double that represents the maximum UV index for a clear sky for the day.
         */
        public double getUv_index_clear_sky_max() {
            return uv_index_clear_sky_max;
        }

        /**
         * Accessor method to get the maximum probability for precipitation.
         * @return double that represents the maximum probability for precipitation for the day.
         */
        public double getPrecipitation_probability_max() {
            return precipitation_probability_max;
        }

        /**
         * Accessor method to get the maximum windspeed for the day.
         * @return double that represents the maximum windspeed for they day.
         */
        public double getWind_speed_10m_max() {
            return wind_speed_10m_max;
        }

        
    }
}
