package by.korolenko.composite.controller.command.impl;

import by.korolenko.composite.controller.command.Command;
import by.korolenko.composite.service.CompositeService;
import by.korolenko.composite.service.factory.ServiceFactory;

public class CollectText implements Command {
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
        return compositeService.collect();
    }
}
