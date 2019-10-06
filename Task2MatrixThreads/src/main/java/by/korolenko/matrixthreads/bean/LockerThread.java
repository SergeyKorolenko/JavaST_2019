package by.korolenko.matrixthreads.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public class LockerThread extends Thread {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(LockerThread.class.getName());
    /**
     * Number to be filled.
     */
    private int number;

    /**
     * Matrix to be filled.
     */
    private int[][] matrix;

    /**
     * Locker.
     */
    private ReentrantLock locker;

    /**
     * This is the constructor with parameters.
     *
     * @param newLocker locker
     * @param newNumber number
     * @param newMatrix matrix
     */
    public LockerThread(final ReentrantLock newLocker, final int newNumber,
                        final int[][] newMatrix) {
        this.locker = newLocker;
        this.number = newNumber;
        this.matrix = newMatrix;
    }

    /**
     * Run method.
     */
    @Override
    public void run() {
        for (int i = 0; i < matrix.length; i++) {
            locker.lock();
            if (matrix[i][i] == 0) {
                System.out.println(getName() + " added number to line " + i);
                matrix[i][i] = number;
            }
            locker.unlock();
            final int timeout = 30;
            try {
                TimeUnit.MILLISECONDS.sleep(timeout);
            } catch (InterruptedException e) {
                LOGGER.error("thread error", e);
            }
        }
    }
}
