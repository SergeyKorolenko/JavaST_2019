package by.korolenko.matrixthreads.repository.specification.impl;

import by.korolenko.matrixthreads.bean.LockerThread;
import by.korolenko.matrixthreads.repository.specification.Specification;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public class LockerSpecification implements Specification {
    /**
     * This is the specified method.
     *
     * @param matrix  matrix
     * @param numbers numbers for thread
     * @return updated matrix
     */
    @Override
    public int[][] specified(final int[][] matrix, final int[] numbers) {
        ReentrantLock locker = new ReentrantLock();
        for (int i = 0; i < numbers.length; i++) {
            new LockerThread(locker, numbers[i], matrix).start();
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
