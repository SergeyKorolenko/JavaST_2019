package by.korolenko.matrixthreads.service.parser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public class StringParser {

    /**
     * String delimiter.
     */
    private static final String DELIMITER = " ";

    /**
     * This method parses list of strings to list of string arrays.
     *
     * @param data data to be parsed
     * @return list of string arrays
     */
    public List<String[]> parseToStringArray(final List<String> data) {
        List<String[]> result = new ArrayList<>();
        for (String line : data) {
            result.add(line.split(DELIMITER));
        }
        return result;
    }
}
