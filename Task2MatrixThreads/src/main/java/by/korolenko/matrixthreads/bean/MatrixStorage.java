package by.korolenko.matrixthreads.bean;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public final class MatrixStorage {
    /**
     * This is the matrix instance.
     */
    private static final MatrixStorage INSTANCE = new MatrixStorage();

    /**
     * Private constructor.
     */
    private MatrixStorage() {
    }

    /**
     * Getter for instance.
     *
     * @return matrix instance
     */
    public static MatrixStorage getInstance() {
        return MatrixStorage.INSTANCE;
    }

    /**
     * This is the matrix.
     */
    private int[][] matrix;

    /**
     * Getter for matrix.
     *
     * @return matrix
     */
    public int[][] getMatrix() {
        int[][] copyMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                copyMatrix[i][j] = matrix[i][j];
            }
        }
        return copyMatrix;
    }

    /**
     * Setter for matrix.
     *
     * @param newMatrix new matrix
     */
    public void setMatrix(final int[][] newMatrix) {
        this.matrix = newMatrix;
    }
}
