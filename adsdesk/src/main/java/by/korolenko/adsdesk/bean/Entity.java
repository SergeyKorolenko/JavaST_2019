package by.korolenko.adsdesk.bean;

import java.io.Serializable;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
 */
public class Entity implements Serializable {

    /**
     * Identifier of entity.
     */
    private int id;

    /**
     * Constructor without parameters.
     */
    public Entity() {
    }

    /**
     * Getter for id.
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for id.
     *
     * @param newId id
     */
    public void setId(final int newId) {
        this.id = newId;
    }
}
