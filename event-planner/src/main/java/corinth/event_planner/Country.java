package corinth.event_planner;

/**
 * This class represents a country.
 */
public class Country {
    /**This is a nested class that represents the currency for the host country. */
    public class CountryCurrency {
        private String code;
        private String name;

        /**
         * Accessor method for {@code code}.
         * @return String the value of {@code code}.
         */
        public String getCode() {
            return this.code;
        }

        /**
         * Accessor method for {@code name}.
         * @return String the value of {@code name}.
         */
        public String getName() {
            return this.name;
        }
    }

    private CountryCurrency currency;

    /**
     * Returns the value of {@code currency}.
     * @return CountryCurrency- the object representation of the currency of a country.
     */
    public CountryCurrency getCurrency() {
        return this.currency;
    }
}

