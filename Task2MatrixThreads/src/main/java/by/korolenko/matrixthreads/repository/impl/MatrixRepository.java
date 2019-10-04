package by.korolenko.matrixthreads.repository.impl;

import by.korolenko.matrixthreads.bean.MatrixStorage;
import by.korolenko.matrixthreads.repository.Repository;
import by.korolenko.matrixthreads.repository.specification.Specification;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public class MatrixRepository implements Repository {

    /**
     * Matrix storage.
     */
    private final MatrixStorage storage = MatrixStorage.getInstance();

    /**
     * This method add filled matrix to matrix storage.
     *
     * @param matrix matrix
     */
    public void addMatrix(final int[][] matrix) {
        storage.setMatrix(matrix);
    }

    /**
     * This method add filled array of numbers to matrix storage.
     *
     * @param numbers numbers
     */
    public void addNumbers(final int[] numbers) {
        storage.setNumbers(numbers);
    }

    /**
     * This method gets matrix from the storage.
     *
     * @return matrix
     */
    public int[][] getMatrix() {
        return storage.getMatrix();
    }

    /**
     * This is the query method.
     *
     * @param specification specification
     * @return array of arrays
     */
    public int[][] query(final Specification specification) {
        return specification.specified(storage.getMatrix(),
                storage.getNumbers());
    }
}
