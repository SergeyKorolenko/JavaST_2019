package by.korolenko.matrixthreads.repository.specification.impl;

import by.korolenko.matrixthreads.bean.LockerThread;
import by.korolenko.matrixthreads.repository.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public class LockerSpecification implements Specification {

    /**
     * Timeout.
     */
    private static final int TIMEOUT = 1;
    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(LockerSpecification.class.getName());

    /**
     * This is the specified method.
     *
     * @param matrix  matrix
     * @param numbers numbers for thread
     * @return updated matrix
     */
    @Override
    public int[][] specified(final int[][] matrix, final int[] numbers) {
        ReentrantLock locker = new ReentrantLock();
        for (int number : numbers) {
            new LockerThread(locker, number, matrix).start();
        }
        try {
            TimeUnit.SECONDS.sleep(TIMEOUT);
        } catch (InterruptedException e) {
            LOGGER.error("thread error", e);
        }
        return matrix;
    }
}
