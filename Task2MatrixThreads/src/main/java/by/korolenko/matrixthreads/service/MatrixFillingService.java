package by.korolenko.matrixthreads.service;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public interface MatrixFillingService {
    /**
     * Filling matrix using lock.
     * @return response
     */
    String fillByLocker();

    /**
     * Filling matrix using semaphore.
     * @return response
     */
    String fillBySemaphore();
}
