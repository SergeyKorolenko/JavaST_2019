package by.korolenko.mobile.controller.command.impl;

import by.korolenko.mobile.controller.command.Command;
import by.korolenko.mobile.service.TariffFindService;
import by.korolenko.mobile.service.factory.ServiceFactory;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public class FindBetweenId implements Command {
    /**
     * This method searches tariffs between id.
     *
     * @param request request string
     * @return response string
     */
    @Override
    public String execute(final String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TariffFindService tariffFindService = serviceFactory.
                getTariffFindService();
        return tariffFindService.findBetweenId(request).toString();
    }
}
