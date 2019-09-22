package by.korolenko.mobile.service.parser;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public class StringParser {

    /**
     * This is the delimiter.
     */
    private static final String DELIMITER = ",";

    /**
     * This method parses string to string array.
     *
     * @param data data
     * @return string array
     */
    public String[] parseToString(final String data) {
        return data.split(DELIMITER);
    }
}
