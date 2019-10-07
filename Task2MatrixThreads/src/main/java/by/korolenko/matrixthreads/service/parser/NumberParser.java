package by.korolenko.matrixthreads.service.parser;

import by.korolenko.matrixthreads.service.validator.NumberValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public class NumberParser {

    /**
     * This method parses list of string array to int array of arrays.
     *
     * @param data data to be parsed
     * @return result list of int arrays
     */
    public List<int[]> parseStringToInt(final List<String[]> data) {
        List<int[]> list = new ArrayList<>();
        NumberValidator numberValidator = new NumberValidator();
        for (String[] line : data) {
            int[] values = new int[line.length];
            for (int i = 0; i < values.length; i++) {
                if (numberValidator.isIntNumber(line[i])) {
                    values[i] = parseToInt(line[i]);
                }
            }
            list.add(values);
        }
        return list;
    }

    /**
     * This method parses string to int number.
     *
     * @param data data to be parsed
     * @return int number
     */
    private int parseToInt(final String data) {
        return Integer.parseInt(data);
    }
}
