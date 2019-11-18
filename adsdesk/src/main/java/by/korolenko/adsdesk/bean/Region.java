package by.korolenko.adsdesk.bean;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
 */
public class Region extends Entity {

    /**
     * Region name.
     */
    private String regionName;

    private Country country;

    public Region() {
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Country getCountryId() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
