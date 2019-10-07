package by.korolenko.matrixthreads.bean;

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
public class CountDownLatchThread extends Thread {
    /**
     * Timeout fo threads.
     */
    private static final int TIMEOUT = 30;
    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(CountDownLatchThread.class.getName());
    /**
     * Number to be filled.
     */
    private int number;

    /**
     * Matrix to be filled.
     */
    private int[][] matrix;

    /**
     * Count down latch.
     */
    private CountDownLatch countDownLatch;

    /**
     * Locker.
     */
    private ReentrantLock locker;

    /**
     * This is the constructor with parameters.
     *
     * @param newCountDownLatch count down latch
     * @param newLocker         locker
     * @param newNumber         number
     * @param newMatrix         matrix
     */
    public CountDownLatchThread(final CountDownLatch newCountDownLatch,
                                final ReentrantLock newLocker,
                                final int newNumber, final int[][] newMatrix) {
        this.locker = newLocker;
        this.countDownLatch = newCountDownLatch;
        this.number = newNumber;
        this.matrix = newMatrix;
    }

    /**
     * Run method.
     */
    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(TIMEOUT);
            countDownLatch.countDown();
            countDownLatch.await();
            for (int i = 0; i < matrix.length; i++) {
                locker.lock();
                if (matrix[i][i] == 0) {
                    System.out.println(getName() + " has added number "
                            + number + " to line " + i);
                    matrix[i][i] = number;
                }
                locker.unlock();
                TimeUnit.MILLISECONDS.sleep(TIMEOUT);
            }
        } catch (InterruptedException e) {
            LOGGER.error("Thread error", e);
        }
    }
}
