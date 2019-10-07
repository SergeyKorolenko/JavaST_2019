package by.korolenko.matrixthreads.service.impl;

import by.korolenko.matrixthreads.repository.Repository;
import by.korolenko.matrixthreads.repository.impl.MatrixRepository;
import by.korolenko.matrixthreads.repository.specification.impl.CountDownLatchSpecification;
import by.korolenko.matrixthreads.repository.specification.impl.LockerSpecification;
import by.korolenko.matrixthreads.repository.specification.impl.PhaserSpecification;
import by.korolenko.matrixthreads.repository.specification.impl.SemaphoreSpecification;
import by.korolenko.matrixthreads.service.MatrixFillingService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public class MatrixFillingServiceImpl implements MatrixFillingService {
    /**
     * Timeout.
     */
    private static final int TIMEOUT = 1;

    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(MatrixFillingServiceImpl.class.getName());
    /**
     * Repository.
     */
    private final Repository repository = new MatrixRepository();

    /**
     * This method fills diagonal elements of the matrix using lock.
     *
     * @return matrix
     */
    @Override
    public String fillByLocker() {
        int[][] matrix = repository.query(new LockerSpecification());
        try {
            TimeUnit.SECONDS.sleep(TIMEOUT);
        } catch (InterruptedException e) {
            LOGGER.error("Thread error : "
                    + Thread.currentThread().getName(), e);
        }
        return toString(matrix);
    }

    /**
     * This method fills diagonal elements of the matrix.
     *
     * @return matrix
     */
    @Override
    public String fillBySemaphore() {
        int[][] matrix = repository.query(new SemaphoreSpecification());
        try {
            TimeUnit.SECONDS.sleep(TIMEOUT);
        } catch (InterruptedException e) {
            LOGGER.error("Error of thread : " + Thread.
                    currentThread().getName(), e);
        }
        return toString(matrix);
    }

    /**
     * This method fills diagonal elements of the matrix.
     *
     * @return matrix
     */
    @Override
    public String fillByPhaser() {
        int[][] matrix = repository.query(new PhaserSpecification());
        try {
            TimeUnit.SECONDS.sleep(TIMEOUT);
        } catch (InterruptedException e) {
            LOGGER.error("Thread error: "
                    + Thread.currentThread().getName(), e);
        }
        return toString(matrix);
    }

    /**
     * This method fills diagonal elements of the matrix.
     *
     * @return matrix
     */
    @Override
    public String fillByCountDownLatch() {
        int[][] matrix = repository.query(new CountDownLatchSpecification());
        try {
            TimeUnit.SECONDS.sleep(TIMEOUT);
        } catch (InterruptedException e) {
            LOGGER.error("Thread error", e);
        }
        return toString(matrix);
    }

    /**
     * Creating matrix as a string.
     *
     * @param matrix matrix
     * @return matrix as a string
     */
    private String toString(final int[][] matrix) {
        StringBuilder result = new StringBuilder();
        for (int[] values : matrix) {
            for (int value : values) {
                result.append(value).append(' ');
            }
            result.append('\n');
        }
        return result.toString();
    }
}
