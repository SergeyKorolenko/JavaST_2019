package by.korolenko.matrixthreads.bean;

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
public class PhaserThread extends Thread {
    /**
     * Timeout fo threads.
     */
    private static final int TIMEOUT = 10;
    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(PhaserThread.class.getName());

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
    private Phaser phaser;

    /**
     * Locker.
     */
    private ReentrantLock locker;
    /**
     * This is the constructor with parameters.
     *
     * @param newPhaser phaser
     * @param newLocker locker
     * @param newNumber number
     * @param newMatrix matrix
     */
    public PhaserThread(final Phaser newPhaser, final ReentrantLock newLocker,
                        final int newNumber, final int[][] newMatrix) {
        this.phaser = newPhaser;
        this.locker = newLocker;
        this.number = newNumber;
        this.matrix = newMatrix;
        phaser.register();
    }

    /**
     * Run method.
     */
    @Override
    public void run() {
        for (int i = 0; i < matrix.length; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(TIMEOUT);
                phaser.arriveAndAwaitAdvance();
                locker.lock();
                if (matrix[i][i] == 0) {
                    System.out.println(getName() + " has added number "
                            + number + " to line " + i);
                    matrix[i][i] = number;
                }
                locker.unlock();
                TimeUnit.MILLISECONDS.sleep(TIMEOUT);
            } catch (InterruptedException e) {
                LOGGER.error("Thread error", e);
            }
        }
        phaser.arriveAndDeregister();
    }
}
