package by.korolenko.composite.controller.command.impl;

import by.korolenko.composite.controller.command.Command;
import by.korolenko.composite.service.CompositeService;
import by.korolenko.composite.service.factory.ServiceFactory;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class ParseText implements Command {

    /**
     * This is the signature of command method.
     *
     * @param request request
     * @return response string
     */
    @Override
    public String execute(final String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CompositeService compositeService = serviceFactory.
                getCompositeService();
        return compositeService.parse();
    }
}
