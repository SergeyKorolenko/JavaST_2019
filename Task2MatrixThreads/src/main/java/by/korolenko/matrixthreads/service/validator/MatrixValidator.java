package by.korolenko.matrixthreads.service.validator;

import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public class MatrixValidator {

    /**
     * this method checks if the data can be a matrix.
     *
     * @param data data to be che
     * @return result
     */
    public boolean isCanBeMatrix(final List<String[]> data) {
        int rowNumber = data.size();
        String[] firstLine = data.get(0);
        int count = 1;
        for (int i = 1; i < rowNumber; i++) {
            String[] line = data.get(i);
            if (firstLine.length == line.length) {
                ++count;
            }
        }
        return count == rowNumber;
    }

    /**
     * This method checks if the matrix is square.
     *
     * @param data data to be checked
     * @return result
     */
    public boolean isSquareMatrix(final List<int[]> data) {
        return data.size() == data.get(0).length;
    }

    /**
     * This method checks diagonal elements on zero.
     *
     * @param matrix matrix to be checked
     * @return result
     */
    public boolean isZeroDiagonal(final int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] == 0) {
                ++count;
            }
        }
        return count == matrix.length;
    }
}
