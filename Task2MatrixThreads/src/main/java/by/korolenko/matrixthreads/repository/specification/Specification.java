package by.korolenko.matrixthreads.repository.specification;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public interface Specification {
    /**
     * This is the specified mehtod.
     *
     * @param matrix  matrix
     * @param numbers numbers for thread
     * @return updated matrix
     */
    int[][] specified(int[][] matrix, int[] numbers);
}
