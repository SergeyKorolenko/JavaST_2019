package by.korolenko.composite.service.output;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class FileDataWriter {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(FileDataWriter.class.getName());

    /**
     * This method writes data to the output file.
     *
     * @param data     data
     * @param fileName file name
     */
    public void writeData(final String data, final String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(new File(fileName)))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            LOGGER.error("Error of writing to the file", e);
        }
    }
}
