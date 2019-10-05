package by.korolenko.matrixthreads.repository.specification.impl;

import by.korolenko.matrixthreads.bean.CallableThread;
import by.korolenko.matrixthreads.repository.specification.Specification;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableSpecification implements Specification {
    /**
     * This is the specified method.
     *
     * @param matrix  matrix
     * @param numbers numbers for thread
     * @return updated matrix
     */
    @Override
    public int[][] specified(final int[][] matrix, final int[] numbers) {
        ExecutorService executorService = Executors.
                newFixedThreadPool(numbers.length);
        for (int i = 0; i < matrix.length; i++) {
            Future<Integer> future = executorService.
                    submit(new CallableThread(numbers));
            try {
                if (matrix[i][i] == 0) {
                    matrix[i][i] = future.get();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
        return matrix;
    }
}
