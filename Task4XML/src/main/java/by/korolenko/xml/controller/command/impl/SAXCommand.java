package by.korolenko.xml.controller.command.impl;

import by.korolenko.xml.bean.GemType;
import by.korolenko.xml.controller.command.Command;
import by.korolenko.xml.service.factory.ServiceFactory;
import by.korolenko.xml.service.impl.SAXService;

import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 29.10.2019
 */
public class SAXCommand implements Command {
    /**
     * Executing method.
     *
     * @param request request
     * @return response
     */
    @Override
    public List<GemType> execute(final String request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        SAXService service = factory.getSAXService();
        return service.parse(request);
    }
}
