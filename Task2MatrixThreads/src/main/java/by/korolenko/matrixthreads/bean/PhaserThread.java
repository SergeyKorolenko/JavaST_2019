package by.korolenko.matrixthreads.bean;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserThread extends Thread {
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
        phaser.register();
    }

    /**
     * Run method.
     */
    public void run() {
        final int phases = 2;
        final int timeout = 10;
        try {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][i] == 0) {
                    System.out.println(Thread.currentThread().getName()
                            + " line " + i);
                    matrix[i][i] = number;
                }
                TimeUnit.MILLISECONDS.sleep(timeout);
            }
            phaser.arriveAndDeregister();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
