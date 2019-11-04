package by.korolenko.xml.service.factory;

import by.korolenko.xml.service.impl.DOMService;
import by.korolenko.xml.service.impl.SAXService;
import by.korolenko.xml.service.impl.StAXService;

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
    public DOMService getDOMService() {
        return new DOMService();
    }

    /**
     * Getter for SAX service.
     *
     * @return SAX service
     */
    public SAXService getSAXService() {
        return new SAXService();
    }

    /**
     * Getter for DOM service.
     *
     * @return DOM service
     */
    public StAXService getStAXService() {
        return new StAXService();
    }
}
