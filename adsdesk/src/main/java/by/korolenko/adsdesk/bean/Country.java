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

    @Override
    public String toString() {
        return "Country [countryName=" + countryName + ", toString()=" + super.toString() + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((countryName == null) ? 0 : countryName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Country other = (Country) obj;
        if (countryName == null) {
            if (other.countryName != null)
                return false;
        } else if (!countryName.equals(other.countryName))
            return false;
        return true;
    }
}
