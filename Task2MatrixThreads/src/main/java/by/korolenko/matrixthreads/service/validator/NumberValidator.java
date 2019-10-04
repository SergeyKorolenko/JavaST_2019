package by.korolenko.matrixthreads.service.validator;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public class NumberValidator {

    /**
     * This method checks data on a int number.
     *
     * @param data data to be checked
     * @return result
     */
    public boolean isIntNumber(final String data) {
        try {
            Integer.parseInt(data);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * This method checks number on positive value.
     *
     * @param number number to be checked
     * @return result
     */
    public boolean isPositiveInt(final int number) {
        return number > 0;
    }

    /**
     * This method checks array on positive value.
     *
     * @param array array to be checked
     * @return result
     */
    public boolean isPositiveArray(final int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                ++count;
            }
        }
        return count == array.length;
    }
}
