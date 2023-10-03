package corinth.event_planner;

/**
 * This class represents a city object.
 */
public class City {

  private String name;
  private double latitude;
  private double longitude;
  private String country;

  /**
   * Getter method for name.
   *
   * @return String Name of the host country.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Getter method for latitude.
   *
   * @return double Latitude of the city.
   */
  public double getLatitude() {
    return this.latitude;
  }

  /**
   * Getter method for the longitude.
   *
   * @return double Longitude of the city.
   */
  public double getLongitude() {
    return this.longitude;
  }

  /**
   * Getter method for the country.
   *
   * @return String Country of the city.
   */
  public String getCountry() {
    return this.country;
  }
}
