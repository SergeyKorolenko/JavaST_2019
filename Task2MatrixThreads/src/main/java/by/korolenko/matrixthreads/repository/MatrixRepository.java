package by.korolenko.matrixthreads.repository;

import by.korolenko.matrixthreads.bean.MatrixStorage;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public class MatrixRepository {

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
     * This method gets matrix from the storage.
     *
     * @return matrix
     */
    public int[][] getMatrix() {
        return storage.getMatrix();
    }
}
