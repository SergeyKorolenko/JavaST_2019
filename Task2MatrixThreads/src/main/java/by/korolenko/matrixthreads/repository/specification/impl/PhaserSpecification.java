package by.korolenko.matrixthreads.repository.specification.impl;

import by.korolenko.matrixthreads.bean.PhaserThread;
import by.korolenko.matrixthreads.repository.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public class PhaserSpecification implements Specification {

    /**
     * Timeout.
     */
    private static final int TIMEOUT = 30;

    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(PhaserSpecification.class.getName());
    /**
     * This is the specified method.
     *
     * @param matrix  matrix
     * @param numbers numbers for thread
     * @return updated matrix
     */
    @Override
    public int[][] specified(final int[][] matrix, final int[] numbers) {
        Phaser phaser = new Phaser(1);
        ReentrantLock locker = new ReentrantLock();
        for (int number : numbers) {
            new PhaserThread(phaser, locker, number, matrix).start();
        }
        try {
            for (int i = 0; i < matrix.length; i++) {
                TimeUnit.MILLISECONDS.sleep(TIMEOUT);
                phaser.arriveAndAwaitAdvance();
            }
            phaser.arriveAndDeregister();
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            LOGGER.error("Thread error", e);
        }
        return matrix;
    }
}
