package by.korolenko.composite.service.input;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class FileDataReader {

    /**
     * This is the logger.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(FileDataReader.class.getName());

    /**
     * This method reads data from any file.
     *
     * @param fileName file name
     * @return list of string
     */
    public String readData(final String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName)),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            LOGGER.error("File error", e);
        }
        return null;
    }

    /**
     * This method reads data from any file.
     *
     * @param fileName file name
     * @return list of string
     */
    public String readSimpleData(final String fileName) {
        List<String> data = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            data = stream.collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.error("File error", e);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String datum : data) {
            stringBuilder.append(datum);
        }
        return stringBuilder.toString();
    }
}
