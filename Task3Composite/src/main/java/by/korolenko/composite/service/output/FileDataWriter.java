package by.korolenko.composite.service.output;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileDataWriter {

    /**
     * Logger.
     */
    private final Logger log = LogManager.getLogger(FileDataWriter.class.
            getName());

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
            log.error("error of writing to file");
        }
    }
}
