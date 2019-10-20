package by.korolenko.composite.service.input;

import by.korolenko.composite.service.exception.ProblemFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class PropertyReader {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(PropertyReader.class.getName());
    /**
     * Property file name.
     */
    private static final String PROPERTY_FILE = "files.properties";

    /**
     * This method reads properties.
     *
     * @param key key
     * @return property
     * @throws ProblemFileException exception
     */
    public String readFilePath(final String key) throws ProblemFileException {
        Properties property = new Properties();
        String fileName;
        try (InputStream fis = getClass().getClassLoader().
                getResourceAsStream(PROPERTY_FILE)) {
            property.load(fis);
            fileName = property.getProperty(key);
        } catch (IOException e) {
            LOGGER.error("Property file error", e);
            throw new ProblemFileException();
        }
        return fileName;
    }
}
