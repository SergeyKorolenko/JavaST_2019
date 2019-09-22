package by.korolenko.mobile.controller.command.impl;

import by.korolenko.mobile.controller.command.Command;
import by.korolenko.mobile.service.TariffCommonService;
import by.korolenko.mobile.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public class AddTariff implements Command {

    /**
     * Logger.
     */
    private final Logger log = LogManager.getLogger(AddTariff.class.getName());

    /**
     * This method adds tariff.
     *
     * @param request request string
     * @return response string
     */
    @Override
    public String execute(final String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TariffCommonService tariffCommonService = serviceFactory.
                getTariffCommonService();
        tariffCommonService.addTariff(request);
        return null;
    }
}
