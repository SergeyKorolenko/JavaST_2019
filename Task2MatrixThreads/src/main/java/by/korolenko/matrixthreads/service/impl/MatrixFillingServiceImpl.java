package by.korolenko.matrixthreads.service.impl;

import by.korolenko.matrixthreads.repository.Repository;
import by.korolenko.matrixthreads.repository.impl.MatrixRepository;
import by.korolenko.matrixthreads.repository.specification.impl.CallableSpecification;
import by.korolenko.matrixthreads.repository.specification.impl.LockerSpecification;
import by.korolenko.matrixthreads.repository.specification.impl.PhaserSpecification;
import by.korolenko.matrixthreads.repository.specification.impl.SemaphoreSpecification;
import by.korolenko.matrixthreads.service.MatrixFillingService;

import java.util.concurrent.TimeUnit;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public class MatrixFillingServiceImpl implements MatrixFillingService {

    /**
     * Repository.
     */
    private final Repository repository = new MatrixRepository();

    /**
     * This method fills diagonal elements of the matrix using lock.
     *
     * @return matrix
     */
    @Override
    public String fillByLocker() {
        int[][] matrix = repository.query(new LockerSpecification());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return toString(matrix);
    }

    /**
     * This method fills diagonal elements of the matrix.
     *
     * @return matrix
     */
    @Override
    public String fillBySemaphore() {
        int[][] matrix = repository.query(new SemaphoreSpecification());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return toString(matrix);
    }

    /**
     * This method fills diagonal elements of the matrix.
     *
     * @return matrix
     */
    @Override
    public String fillByCallable() {
        int[][] matrix = repository.query(new CallableSpecification());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return toString(matrix);
    }

    /**
     * This method fills diagonal elements of the matrix.
     *
     * @return matrix
     */
    @Override
    public String fillByPhaser() {
        int[][] matrix = repository.query(new PhaserSpecification());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return toString(matrix);
    }

    /**
     * Creating matrix as a string.
     *
     * @param matrix matrix
     * @return matrix as a string
     */
    private String toString(final int[][] matrix) {
        String result = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result += matrix[i][j] + " ";
            }
            result += "\n";
        }
        return result;
    }
}
