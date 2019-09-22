package by.korolenko.mobile.service;

import java.util.List;

public interface TariffFileService {

    /**
     * Read from file.
     */
    void readFromFile();

    /**
     * Write to file.
     *
     * @param data data
     */
    void writeToFile(List<String> data);
}
