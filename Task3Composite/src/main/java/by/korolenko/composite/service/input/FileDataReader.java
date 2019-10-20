package by.korolenko.composite.service.input;

import by.korolenko.composite.service.exception.ProblemFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class FileDataReader {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(FileDataReader.class.getName());

    /**
     * This method reads data from any file.
     *
     * @param fileName file name
     * @return list of string
     * @throws ProblemFileException exception
     */
    public String readData(final String fileName) throws ProblemFileException {
        String text;
        Path path = Paths.get(fileName);
        if (Files.notExists(path)) {
            LOGGER.error("No such file");
            throw new ProblemFileException();
        }
        try {
            text = new String(Files.readAllBytes(path));
        } catch (IOException e) {
            LOGGER.error("File error", e);
            throw new ProblemFileException();
        }
        return text;
    }
}
