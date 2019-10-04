package by.korolenko.matrixthreads.bean;

import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public class MatrixFillingThread extends Thread {

    /**
     * Start string index.
     */
    private int start;
    /**
     * End string index.
     */
    private int end;

    /**
     * Sublist to be filled.
     */
    private List<int[]> sublist;
    /**
     * Matrix to be filled.
     */
    private int[][] matrix;

    /**
     * This is the constructor with parameters.
     *
     * @param newStart   start index
     * @param newEnd     end index
     * @param newSublist sublist
     * @param newMatrix  matrix
     */
    public MatrixFillingThread(final int newStart, final int newEnd,
                               final List<int[]> newSublist,
                               final int[][] newMatrix) {
        this.start = newStart;
        this.end = newEnd;
        this.sublist = newSublist;
        this.matrix = newMatrix;
    }

    /**
     * Run method.
     */
    @Override
    public void run() {
        for (int i = start, k = 0; i < end; i++, k++) {
            System.out.println(getName() + " added line "
                    + i + " to the matrix");
            matrix[i] = sublist.get(k);
        }
    }
}
