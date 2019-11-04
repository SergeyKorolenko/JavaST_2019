package by.korolenko.xml.controller.command.impl;

import by.korolenko.xml.bean.GemType;
import by.korolenko.xml.controller.command.Command;
import by.korolenko.xml.service.factory.ServiceFactory;
import by.korolenko.xml.service.impl.StAXService;

import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 29.10.2019
 */
public class StAXCommand implements Command {
    /**
     * Executing method.
     *
     * @param request request
     * @return response
     */
    @Override
    public List<GemType> execute(final String request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        StAXService service = factory.getStAXService();
        return service.parse(request);
    }
}
