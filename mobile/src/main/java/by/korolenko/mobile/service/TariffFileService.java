package by.korolenko.mobile.service;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public interface TariffFileService {

    /**
     * Read from file.
     * @return number of read
     */
    int readFromFile();

    /**
     * Write to file.
     *
     * @return number of written
     */
    int writeToFile();
}
