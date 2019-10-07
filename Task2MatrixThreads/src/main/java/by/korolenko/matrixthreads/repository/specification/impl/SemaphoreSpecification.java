package by.korolenko.matrixthreads.repository.specification.impl;

import by.korolenko.matrixthreads.bean.SemaphoreThread;
import by.korolenko.matrixthreads.repository.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public class SemaphoreSpecification implements Specification {

    /**
     * Timeout.
     */
    private static final int TIMEOUT = 1;
    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(SemaphoreSpecification.class.getName());

    /**
     * This is the specified method.
     *
     * @param matrix  matrix
     * @param numbers numbers for thread
     * @return updated matrix
     */
    @Override
    public int[][] specified(final int[][] matrix, final int[] numbers) {
        Random random = new Random();
        int permits = random.nextInt(numbers.length + 1) + 1;
        Semaphore semaphore = new Semaphore(permits);
        for (int number : numbers) {
            new SemaphoreThread(semaphore, number, matrix).start();
        }
        try {
            TimeUnit.SECONDS.sleep(TIMEOUT);
        } catch (InterruptedException e) {
            LOGGER.error("thread error", e);
        }
        return matrix;
    }
}
