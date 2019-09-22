package by.korolenko.mobile.controller.command.impl;

import by.korolenko.mobile.controller.command.Command;
import by.korolenko.mobile.service.TariffCommonService;
import by.korolenko.mobile.service.factory.ServiceFactory;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public class GetAllTariff implements Command {
    /**
     * This method returns list of tariff as a string.
     *
     * @param request request string
     * @return response string
     */
    @Override
    public String execute(final String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TariffCommonService tariffCommonService = serviceFactory.
                getTariffCommonService();
        return tariffCommonService.getAllTariff().toString();
    }
}
