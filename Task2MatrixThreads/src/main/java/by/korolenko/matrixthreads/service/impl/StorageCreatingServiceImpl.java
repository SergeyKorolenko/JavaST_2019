package by.korolenko.matrixthreads.service.impl;

import by.korolenko.matrixthreads.repository.Repository;
import by.korolenko.matrixthreads.repository.impl.MatrixRepository;
import by.korolenko.matrixthreads.service.StorageCreatingService;
import by.korolenko.matrixthreads.service.input.FileDataReader;
import by.korolenko.matrixthreads.service.input.PropertyReader;
import by.korolenko.matrixthreads.service.input.enums.PropertyKey;
import by.korolenko.matrixthreads.service.parser.NumberParser;
import by.korolenko.matrixthreads.service.parser.StringParser;
import by.korolenko.matrixthreads.service.validator.MatrixValidator;
import by.korolenko.matrixthreads.service.validator.NumberValidator;

import java.util.Arrays;
import java.util.List;

public class StorageCreatingServiceImpl implements StorageCreatingService {

    /**
     * Repository.
     */
    private final Repository repository = new MatrixRepository();

    /**
     * Creating storage.
     *
     * @return response
     */
    public String createStorage() {
        int[][] matrix = createMatrix();
        int[] numbers = createNumbers();
        if (matrix.length != 0 && numbers.length != 0) {
            repository.addMatrix(matrix);
            repository.addNumbers(numbers);
            return toString(matrix) + "\n" + Arrays.toString(numbers) + "\n";
        }
        return "Creating storage error";
    }

    /**
     * This is matrix filling method.
     *
     * @return matrix
     */
    private int[][] createMatrix() {
        FileDataReader dataReader = new FileDataReader();
        PropertyReader propertyReader = new PropertyReader();
        StringParser parser = new StringParser();
        List<String> stringList = dataReader.readData(propertyReader.
                readFilePath(PropertyKey.MATRIX.getKeyName()));
        List<String[]> arrayList = parser.parseToStringArray(stringList);
        MatrixValidator matrixValidator = new MatrixValidator();
        if (matrixValidator.isCanBeMatrix(arrayList)) {
            NumberParser numberParser = new NumberParser();
            List<int[]> intList = numberParser.
                    parseStringToInt(arrayList);
            if (matrixValidator.isSquareMatrix(intList)) {
                int[][] matrix = new int[intList.size()][intList.size()];
                if (matrixValidator.isZeroDiagonal(matrix)) {
                    for (int i = 0; i < matrix.length; i++) {
                        matrix[i] = intList.get(i);
                    }
                    return matrix;
                }
            }
        }
        return new int[0][];
    }

    /**
     * This matrix fills diagonal elements of the matrix.
     *
     * @return array of numbers
     */
    private int[] createNumbers() {
        FileDataReader dataReader = new FileDataReader();
        PropertyReader propertyReader = new PropertyReader();
        List<String> stringList = dataReader.readData(propertyReader.
                readFilePath(PropertyKey.NUMBERS.getKeyName()));
        StringParser parser = new StringParser();
        List<String[]> arrayList = parser.parseToStringArray(stringList);
        NumberParser numberParser = new NumberParser();
        List<int[]> intList = numberParser.parseStringToInt(arrayList);
        if (intList.size() == 1) {
            int[] numbers = intList.get(0);
            NumberValidator numberValidator = new NumberValidator();
            if (numberValidator.isPositiveArray(numbers)) {
                return numbers;
            }
        }
        return new int[0];
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
