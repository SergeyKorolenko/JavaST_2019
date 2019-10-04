package by.korolenko.matrixthreads.repository.specification.impl;

import by.korolenko.matrixthreads.bean.SemaphoreThread;
import by.korolenko.matrixthreads.repository.specification.Specification;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public class SemaphoreSpecification implements Specification {
    /**
     * This is the specified method.
     *
     * @param matrix  matrix
     * @param numbers numbers for thread
     * @return updated matrix
     */
    @Override
    public int[][] specified(final int[][] matrix, final int[] numbers) {
        Semaphore semaphore = new Semaphore(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            new SemaphoreThread(semaphore, numbers[i], matrix).start();
        }
        final int timeout = 1;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return matrix;
    }
}
