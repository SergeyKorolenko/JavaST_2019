package by.korolenko.matrixthreads.service;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public interface StorageService {
    /**
     * Creating storage.
     *
     * @return response
     */
    Boolean createStorage();

    /**
     * Showing data from storage.
     *
     * @return response
     */
    String showStorageData();
}
