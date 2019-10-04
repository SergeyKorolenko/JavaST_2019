package by.korolenko.matrixthreads.service.input;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public class PropertyReader {

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
            e.printStackTrace();
            fileName = "";
        }
        return fileName;
    }
}
