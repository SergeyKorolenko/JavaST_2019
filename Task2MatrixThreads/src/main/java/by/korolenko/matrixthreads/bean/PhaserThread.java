package by.korolenko.matrixthreads.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public class PhaserThread extends Thread {
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
     * Phaser.
     */
    private Phaser phaser;

    /**
     * This is the constructor with parameters.
     *
     * @param newPhaser phaser
     * @param newNumber number
     * @param newMatrix matrix
     */
    public PhaserThread(final Phaser newPhaser, final int newNumber,
                        final int[][] newMatrix) {
        this.phaser = newPhaser;
        this.number = newNumber;
        this.matrix = newMatrix;
    }

    /**
     * Run method.
     */
    @Override
    public void run() {
        final int timeout = 10;
        try {
            phaser.register();
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][i] == 0) {
                    System.out.println(Thread.currentThread().getName()
                            + " line " + i);
                    matrix[i][i] = number;
                }
                phaser.arriveAndAwaitAdvance();
                TimeUnit.MILLISECONDS.sleep(timeout);
            }
        } catch (InterruptedException e) {
            LOGGER.error("thread error", e);
        }
        phaser.arriveAndDeregister();
    }
}
