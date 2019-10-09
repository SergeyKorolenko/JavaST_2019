package by.korolenko.composite.service.factory;

import by.korolenko.composite.service.CompositeService;
import by.korolenko.composite.service.impl.CompositeServiceImpl;

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
     * Getter for common tariff service.
     *
     * @return common tariff service
     */
    public CompositeService getCompositeService() {
        return compositeService;
    }
}
