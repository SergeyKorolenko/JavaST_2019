package by.korolenko.mobile.controller.command;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public enum CommandName {
    /**
     * Add tariff.
     */
    ADD_TARIFF,
    /**
     * Get all tariffs.
     */
    GET_ALL,
    /**
     * Read from file.
     */
    READ_FROM_FILE,
    /**
     * Delete tariff.
     */
    DELETE_TARIFF,
    /**
     * Update tariff.
     */
    UPDATE_TARIFF,
    /**
     * Sort by id.
     */
    SORT_BY_ID,
    /**
     * Sort by name.
     */
    SORT_BY_NAME,
    /**
     * Find by id.
     */
    FIND_BY_ID,
    /**
     * Find by name.
     */
    FIND_BY_NAME,
    /**
     * Find between two id.
     */
    FIND_BETWEEN_ID
}
