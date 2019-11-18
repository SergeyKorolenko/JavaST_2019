package by.korolenko.adsdesk.bean;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
 */
public class Image extends Entity {

    /**
     * Image url.
     */
    private String imageUrl;

    /**
     * Ads.
     */
    private Ads ads;

    /**
     * Constructor without parameters.
     */
    public Image() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Ads getAds() {
        return ads;
    }

    public void setAds(Ads ads) {
        this.ads = ads;
    }
}
