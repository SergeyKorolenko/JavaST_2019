package by.korolenko.matrixthreads.service.input;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
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
    public List<String> readData(final String fileName) {
        List<String> data = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            data = stream.collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.error("error of reading from file: " + fileName, e);
        }
        return data;
    }
}
