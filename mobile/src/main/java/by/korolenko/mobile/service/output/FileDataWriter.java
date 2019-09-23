package by.korolenko.mobile.service.output;

import by.korolenko.mobile.service.validator.FileValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
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
     * @return number of written
     */
    public int writeData(final List<String> data, final String fileName) {
        int result = 0;
        FileValidator fileValidator = new FileValidator();
        if (!fileValidator.isFile(new File(fileName))) {
            return result;
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(fileName))) {
            for (String line : data) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                result++;
            }
        } catch (IOException e) {
            log.error("error of writing to file");
        }
        return result;
    }
}
