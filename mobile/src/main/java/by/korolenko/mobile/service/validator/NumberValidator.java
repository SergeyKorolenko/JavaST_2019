package by.korolenko.mobile.service.validator;

public class NumberValidator {

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
            return false;
        }
    }
}
