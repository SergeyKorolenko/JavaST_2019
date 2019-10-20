package by.korolenko.composite.service.factory;

import by.korolenko.composite.service.CompositeService;
import by.korolenko.composite.service.SortService;
import by.korolenko.composite.service.impl.CompositeServiceImpl;
import by.korolenko.composite.service.impl.SortServiceImpl;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public final class ServiceFactory {
    /**
     * This is service factory instance.
     */
    private static final ServiceFactory INSTANCE = new ServiceFactory();

    /**
     * Composite service.
     */
    private final CompositeService compositeService =
            new CompositeServiceImpl();

    /**
     * Composite service.
     */
    private final SortService sortService =
            new SortServiceImpl();

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
        return ServiceFactory.INSTANCE;
    }

    /**
     * Getter for composite service.
     *
     * @return composite service
     */
    public CompositeService getCompositeService() {
        return compositeService;
    }

    /**
     * Getter for sort service.
     *
     * @return sort service
     */
    public SortService getSortService() {
        return sortService;
    }
}
