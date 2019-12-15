package by.korolenko.adsdesk.bean;

import java.io.Serializable;

/**
 * @author Sergei Korolenko
 * @version 1.0
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

    @Override
    public String toString() {
        return "Entity [id=" + id + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Entity other = (Entity) obj;
        return id != other.id;
    }
}
