package by.korolenko.adsdesk.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
 */
public class Ads extends Entity {

    private String heading;
    private String text;
    private Double price;
    private State status;
    private State bargain;
    private User user;
    private Category category;
    private Locality locality;

    private List<Comment> commentList = new ArrayList<>();
    private List<Image> imageList = new ArrayList<>();

    public Ads() {
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public State getStatus() {
        return status;
    }

    public void setStatus(State status) {
        this.status = status;
    }

    public State getBargain() {
        return bargain;
    }

    public void setBargain(State bargain) {
        this.bargain = bargain;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Locality getLocality() {
        return locality;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public List<Image> getImageList() {
        return imageList;
    }
}
