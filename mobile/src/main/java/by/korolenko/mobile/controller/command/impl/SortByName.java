package by.korolenko.mobile.controller.command.impl;

import by.korolenko.mobile.controller.command.Command;
import by.korolenko.mobile.service.TariffSortService;
import by.korolenko.mobile.service.factory.ServiceFactory;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public class SortByName implements Command {
    /**
     * This method sorts tariffs by name.
     *
     * @param request request string
     * @return response string
     */
    @Override
    public String execute(final String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TariffSortService tariffSortService = serviceFactory.
                getTariffSortService();
        return tariffSortService.sortByName().toString();
    }
}
