package by.korolenko.composite.controller.command.impl;

import by.korolenko.composite.controller.command.Command;
import by.korolenko.composite.service.SortService;
import by.korolenko.composite.service.factory.ServiceFactory;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class SortBySentenceCount implements Command {
    /**
     * This is the signature of command method.
     *
     * @param request request
     * @return response string
     */
    @Override
    public String execute(final String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        SortService sortService = serviceFactory.
                getSortService();
        return sortService.sortBySentenceCount();
    }
}
