package by.korolenko.matrixthreads.service.factory;

import by.korolenko.matrixthreads.service.MatrixFillingService;
import by.korolenko.matrixthreads.service.StorageCreatingService;
import by.korolenko.matrixthreads.service.impl.MatrixFillingServiceImpl;
import by.korolenko.matrixthreads.service.impl.StorageCreatingServiceImpl;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public final class ServiceFactory {

    /**
     * This is service factory instance.
     */
    private static final ServiceFactory INSTANCE = new ServiceFactory();

    /**
     * Storage creating service.
     */
    private final StorageCreatingService storageCreatingService =
            new StorageCreatingServiceImpl();

    /**
     * Matrix filling service.
     */
    private final MatrixFillingService matrixFillingService =
            new MatrixFillingServiceImpl();

    /**
     * Constructor.
     */
    private ServiceFactory() {
    }

    /**
     * Getter for service factory instance.
     *
     * @return service factory instance
     */
    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    /**
     * Getter.
     *
     * @return storage creating service.
     */
    public StorageCreatingService getStorageCreatingService() {
        return storageCreatingService;
    }

    /**
     * Getter.
     *
     * @return matrix filling service.
     */
    public MatrixFillingService getMatrixFillingService() {
        return matrixFillingService;
    }
}
