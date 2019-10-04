package by.korolenko.matrixthreads.repository;

import by.korolenko.matrixthreads.repository.specification.Specification;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public interface Repository {

    /**
     * Add matrix to the storage.
     *
     * @param matrix matrix
     */
    void addMatrix(int[][] matrix);

    /**
     * Add threads numbers.
     *
     * @param numbers numbers
     */
    void addNumbers(int[] numbers);

    /**
     * Get matrix from storage.
     *
     * @return matrix
     */
    int[][] getMatrix();

    /**
     * Query method.
     *
     * @param specification specification
     * @return matrix
     */
    int[][] query(Specification specification);
}
