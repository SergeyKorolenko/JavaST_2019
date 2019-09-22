package by.korolenko.mobile.controller.command.impl;

import by.korolenko.mobile.controller.command.Command;
import by.korolenko.mobile.service.TariffSortService;
import by.korolenko.mobile.service.factory.ServiceFactory;

public class SortByIdAndName implements Command {
    /**
     * This method sorts tariffs by id and then by name.
     *
     * @param request request string
     * @return response string
     */
    @Override
    public String execute(final String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TariffSortService tariffSortService = serviceFactory.
                getTariffSortService();
        return tariffSortService.sortByIdAndName().toString();
    }
}
