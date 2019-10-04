package by.korolenko.matrixthreads.bean;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public class LockerThread extends Thread {

    /**
     * Number to be filled.
     */
    private int number;

    /**
     * Matrix to be filled.
     */
    private int[][] matrix;

    /**
     * Semaphore.
     */
    private ReentrantLock locker;

    /**
     * This is the constructor with parameters.
     *
     * @param newLocker semaphore
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
    public void run() {
        int i = 0;
        while (i < matrix.length) {
            locker.lock();
            if (matrix[i][i] == 0) {
                System.out.println(getName() + " added number to line " + i);
                matrix[i][i] = number;
            }
            i++;
            locker.unlock();
            final int timeout = 30;
            try {
                TimeUnit.MILLISECONDS.sleep(timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
