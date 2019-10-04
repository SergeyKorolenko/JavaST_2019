package by.korolenko.matrixthreads.service;

import by.korolenko.matrixthreads.bean.LockerThread;
import by.korolenko.matrixthreads.bean.MatrixFillingThread;
import by.korolenko.matrixthreads.bean.SemaphoreThread;
import by.korolenko.matrixthreads.repository.MatrixRepository;
import by.korolenko.matrixthreads.service.input.FileDataReader;
import by.korolenko.matrixthreads.service.parser.NumberParser;
import by.korolenko.matrixthreads.service.parser.StringParser;
import by.korolenko.matrixthreads.service.validator.MatrixValidator;
import by.korolenko.matrixthreads.service.validator.NumberValidator;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public class MatrixFillingService {

    /**
     * Matrix input data.
     */
    private static final String MATRIX_FILE_NAME = "data/matrix.txt";
    /**
     * Threads input data.
     */
    private static final String THREADS_FILE_NAME = "data/numbers.txt";

    /**
     * This is matrix filling method.
     */
    public void fillMatrix() {
        FileDataReader dataReader = new FileDataReader();
        List<String> stringList = dataReader.readData(MATRIX_FILE_NAME);
        StringParser parser = new StringParser();
        List<String[]> arrayList = parser.parseToStringArray(stringList);
        MatrixValidator matrixValidator = new MatrixValidator();
        if (matrixValidator.isCanBeMatrix(arrayList)) {
            NumberParser numberParser = new NumberParser();
            List<int[]> intList = numberParser.parseStringToInt(arrayList);
            if (matrixValidator.isSquareMatrix(intList)) {
                int[][] matrix = new int[intList.size()][intList.size()];
                final int threadNumber = 4;
                final int k = intList.size() / threadNumber;
                System.out.println("number k = " + k);
                print(matrix);
                for (int i = 0, j = 0; i < threadNumber; i++, j += k) {
                    int end = j + k;
                    new MatrixFillingThread(j, end, intList.subList(j, end),
                            matrix).start();
                }
                if (matrixValidator.isZeroDiagonal(matrix)) {
                    MatrixRepository repository = new MatrixRepository();
                    repository.addMatrix(matrix);
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                print(matrix);
            }
        }
    }

    /**
     * Print matrix.
     *
     * @param matrix matrix
     */
    private void print(final int[][] matrix) {
        System.out.println("---------------");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------");
    }

    /**
     * This matrix fills diagonal elements of the matrix.
     */
    public void fillDiagonal() {
        MatrixRepository repository = new MatrixRepository();
        int[][] matrix = repository.getMatrix();
        FileDataReader dataReader = new FileDataReader();
        List<String> stringList = dataReader.readData(THREADS_FILE_NAME);
        StringParser parser = new StringParser();
        List<String[]> arrayList = parser.parseToStringArray(stringList);
        NumberParser numberParser = new NumberParser();
        List<int[]> intList = numberParser.parseStringToInt(arrayList);
        if (intList.size() == 1) {
            int[] numbers = intList.get(0);
            NumberValidator numberValidator = new NumberValidator();
            if (numberValidator.isPositiveArray(numbers)) {
                final int threadNumber = numbers.length;
                Semaphore semaphore = new Semaphore(threadNumber);
                for (int i = 0; i < threadNumber; i++) {
                    new SemaphoreThread(semaphore, numbers[i], matrix).start();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                print(matrix);
            }
        }
    }

    /**
     * This matrix fills diagonal elements of the matrix.
     */
    public void fillDiagonalByLocker() {
        MatrixRepository repository = new MatrixRepository();
        int[][] matrix = repository.getMatrix();
        FileDataReader dataReader = new FileDataReader();
        List<String> stringList = dataReader.readData(THREADS_FILE_NAME);
        StringParser parser = new StringParser();
        List<String[]> arrayList = parser.parseToStringArray(stringList);
        NumberParser numberParser = new NumberParser();
        List<int[]> intList = numberParser.parseStringToInt(arrayList);
        if (intList.size() == 1) {
            int[] numbers = intList.get(0);
            NumberValidator numberValidator = new NumberValidator();
            if (numberValidator.isPositiveArray(numbers)) {
                final int threadNumber = numbers.length;
                ReentrantLock locker = new ReentrantLock();
                for (int i = 0; i < threadNumber; i++) {
                    new LockerThread(locker, numbers[i], matrix).start();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                print(matrix);
            }
        }
    }
}
