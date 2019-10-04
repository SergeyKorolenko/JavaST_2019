package by.korolenko.matrixthreads.bean;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public class SemaphoreThread extends Thread {

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
    private Semaphore semaphore;

    /**
     * This is the constructor with parameters.
     *
     * @param newSemaphore semaphore
     * @param newNumber    number
     * @param newMatrix    matrix
     */
    public SemaphoreThread(final Semaphore newSemaphore, final int newNumber,
                           final int[][] newMatrix) {
        this.semaphore = newSemaphore;
        this.number = newNumber;
        this.matrix = newMatrix;
    }

    /**
     * Run method.
     */
    @Override
    public void run() {
        int i = 0;
        while (i < matrix.length) {
            try {
                semaphore.acquire();
                if (matrix[i][i] == 0) {
                    matrix[i][i] = number;
                    System.out.println("Thread " + getName()
                            + " has added number " + number
                            + " to line " + i);
                    final int timeout = 100;
                    TimeUnit.MILLISECONDS.sleep(timeout);
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            i++;
            semaphore.release();
        }
    }
}