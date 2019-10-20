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
     * @return response string
     */
    @Override
    public String execute() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CompositeService compositeService = serviceFactory.
                getCompositeService();
        compositeService.parse();
        return "Text has bee parsed.";
    }
}
