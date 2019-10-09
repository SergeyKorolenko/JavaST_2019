package by.korolenko.composite.controller;

import by.korolenko.composite.service.CompositeService;
import by.korolenko.composite.service.factory.ServiceFactory;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public final class Controller {
    private Controller() {
    }

    /**
     * Main.
     *
     * @param args args
     */
    public static void main(final String[] args) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CompositeService compositeService = serviceFactory.
                getCompositeService();
        compositeService.add();
        compositeService.collect();
    }
}
