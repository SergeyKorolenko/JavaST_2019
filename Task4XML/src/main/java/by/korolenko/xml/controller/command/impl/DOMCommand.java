package by.korolenko.xml.controller.command.impl;

import by.korolenko.xml.bean.GemType;
import by.korolenko.xml.controller.command.Command;
import by.korolenko.xml.service.ParseService;
import by.korolenko.xml.service.factory.ServiceFactory;

import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 29.10.2019
 */
public class DOMCommand implements Command {
    /**
     * Executing method.
     *
     * @param fileName request
     * @param parserType parser type
     * @return response
     */
    @Override
    public List<GemType> execute(final String fileName,
                                 final String parserType) {
        ServiceFactory factory = ServiceFactory.getInstance();
        ParseService parseService = factory.getService();
        return parseService.parse(fileName, parserType);
    }
}
