package by.korolenko.mobile.service.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public class NumberValidator {

    /**
     * Logger.
     */
    private final Logger log = LogManager.getLogger(NumberValidator.class.
            getName());

    /**
     * This method checks data.
     *
     * @param data data
     * @return check result
     */
    public boolean isInt(final String data) {
        try {
            return Integer.parseInt(data) > 0;
        } catch (NumberFormatException e) {
            log.error("Not int: " + data, e);
            return false;
        }
    }

    /**
     * This method checks data.
     *
     * @param data data
     * @return check result
     */
    public boolean isDouble(final String data) {
        try {
            return Double.parseDouble(data) > 0.0;
        } catch (NumberFormatException e) {
            log.error("Not double: " + data, e);
            return false;
        }
    }
}
