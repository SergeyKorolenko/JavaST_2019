package by.korolenko.mobile.service.validator;

import java.io.File;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public class FileValidator {

    /**
     * This method checks file on existing.
     *
     * @param file file name
     * @return result
     */
    public boolean isFile(final File file) {
        if (file != null && !file.isDirectory() && file.isFile()) {
            return true;
        }
        return false;
    }
}
