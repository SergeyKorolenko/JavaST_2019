package by.korolenko.composite.service.input;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    /**
     * This is the logger.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(PropertyReader.class.getName());

    /**
     * This method reads properties.
     *
     * @param key key
     * @return property
     */
    public String readFilePath(final String key) {
        Properties property = new Properties();
        String fileName;
        String propertyFile = "files.properties";
        try (InputStream fis = getClass().getClassLoader().
                getResourceAsStream(propertyFile)) {
            property.load(fis);
            fileName = property.getProperty(key);
        } catch (IOException e) {
            LOGGER.error("property file error", e);
            fileName = "";
        }
        return fileName;
    }
}
