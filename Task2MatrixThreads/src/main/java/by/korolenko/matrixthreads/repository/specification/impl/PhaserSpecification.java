package by.korolenko.matrixthreads.repository.specification.impl;

import by.korolenko.matrixthreads.bean.PhaserThread;
import by.korolenko.matrixthreads.repository.specification.Specification;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserSpecification implements Specification {
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
        for (int i = 0; i < numbers.length; i++) {
            new PhaserThread(phaser, numbers[i], matrix).start();
        }
        phaser.arriveAndDeregister();
        final int timeout = 1;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return matrix;
    }
}
