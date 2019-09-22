package by.korolenko.mobile.service.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public class StringParser {

    /**
     * This is the logger.
     */
    private static Logger log = LogManager.
            getLogger(StringParser.class.getName());

    /**
     * This is the delimiter.
     */
    private static final String DELIMITER = ",";

    /**
     * This method parses data.
     *
     * @param data data
     * @return list of lists
     */
    public List<String[]> parseToStringList(final List<String> data) {
        List<String[]> result = new ArrayList<>();
        for (String line : data) {
            String[] dataLine = line.split(DELIMITER);
            result.add(dataLine);
        }
        return result;
    }

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
