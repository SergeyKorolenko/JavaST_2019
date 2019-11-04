package by.korolenko.xml.service.factory;

import by.korolenko.xml.service.ParseService;
import by.korolenko.xml.service.impl.ParseServiceImpl;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 29.10.2019
 */
public final class ServiceFactory {
    /**
     * This is service factory instance.
     */
    private static final ServiceFactory INSTANCE = new ServiceFactory();

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
     * Getter for DOM service.
     *
     * @return DOM service
     */
    public ParseService getService() {
        return new ParseServiceImpl();
    }
}
