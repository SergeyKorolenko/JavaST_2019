package by.korolenko.matrixthreads.repository.specification.impl;

import by.korolenko.matrixthreads.bean.CountDownLatchThread;
import by.korolenko.matrixthreads.repository.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public class CountDownLatchSpecification implements Specification {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(CountDownLatchSpecification.class.getName());
    /**
     * Timeout.
     */
    private static final int TIMEOUT = 1;

    /**
     * This is the specified method.
     *
     * @param matrix  matrix
     * @param numbers numbers for thread
     * @return updated matrix
     */
    @Override
    public int[][] specified(final int[][] matrix, final int[] numbers) {
        CountDownLatch countDownLatch = new CountDownLatch(numbers.length + 1);
        ReentrantLock locker = new ReentrantLock();
        for (int number : numbers) {
            new CountDownLatchThread(countDownLatch, locker, number, matrix).
                    start();
        }
        try {
            while (countDownLatch.getCount() > 1) {
                TimeUnit.MILLISECONDS.sleep(TIMEOUT);
            }
            countDownLatch.countDown();
            TimeUnit.SECONDS.sleep(TIMEOUT);
        } catch (InterruptedException e) {
            LOGGER.error("Thread error", e);
        }
        return matrix;
    }
}
