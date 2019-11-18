package by.korolenko.adsdesk.bean;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
 */
public class Country extends Entity {

    /**
     * Name of country.
     */
    private String countryName;

    /**
     * Constructor without parameters.
     */
    public Country() {
    }

    /**
     * Getter for country name.
     *
     * @return country name
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Setter for country name.
     *
     * @param newCountryName country name
     */
    public void setCountryName(final String newCountryName) {
        this.countryName = newCountryName;
    }
}
