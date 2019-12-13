package by.korolenko.adsdesk.bean.enums;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public enum State {

    ACTIVE("active"),
    INACTIVE("inactive");

    /**
     * Role name.
     */
    private String stateName;

    State(final String newStateName) {
        this.stateName = newStateName;
    }

    /**
     * Getter for state name.
     *
     * @return state name
     */
    public String getStateName() {
        return stateName;
    }

    /**
     * Getter for id.
     *
     * @return id
     */
    public Integer getId() {
        return ordinal();
    }

    /**
     * Getter for state by id.
     *
     * @param id id
     * @return state
     */
    public static State getById(final Integer id) {
        return State.values()[id];
    }
}
