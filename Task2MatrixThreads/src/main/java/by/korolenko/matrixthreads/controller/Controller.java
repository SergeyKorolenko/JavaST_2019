package by.korolenko.matrixthreads.controller;

import by.korolenko.matrixthreads.service.MatrixFillingService;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public final class Controller {
    /**
     * Private constructor.
     */
    private Controller() {
    }

    /**
     * This is the main method.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        MatrixFillingService matrixService = new MatrixFillingService();
        matrixService.fillMatrix();
        //matrixService.fillDiagonal();
        matrixService.fillDiagonalByLocker();
    }
}
