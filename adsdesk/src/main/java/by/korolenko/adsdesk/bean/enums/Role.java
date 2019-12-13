package by.korolenko.adsdesk.bean.enums;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public enum Role {
    /**
     * Administrator.
     */
    ADMINISTRATOR("admin"),
    /**
     * User.
     */
    USER("user");

    /**
     * Role name.
     */
    private String roleName;

    Role(final String newRoleName) {
        this.roleName = newRoleName;
    }

    /**
     * Getter for role name.
     *
     * @return role name
     */
    public String getRoleName() {
        return roleName;
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
     * Getter for role by id.
     *
     * @param id id
     * @return role
     */
    public static Role getById(final Integer id) {
        return Role.values()[id];
    }
}
