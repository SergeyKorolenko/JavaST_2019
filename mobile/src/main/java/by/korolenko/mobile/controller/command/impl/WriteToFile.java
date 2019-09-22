package by.korolenko.mobile.controller.command.impl;

import by.korolenko.mobile.controller.command.Command;
import by.korolenko.mobile.service.TariffFileService;
import by.korolenko.mobile.service.factory.ServiceFactory;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public class WriteToFile implements Command {
    /**
     * This method reads tariff data from the file.
     *
     * @param request request string
     * @return response string
     */
    @Override
    public String execute(final String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TariffFileService tariffFileService = serviceFactory.
                getTariffFileService();
        Integer response = tariffFileService.writeToFile();
        return response.toString();
    }
}
