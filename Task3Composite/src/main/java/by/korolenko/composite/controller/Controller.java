package by.korolenko.composite.controller;

import by.korolenko.composite.controller.command.Command;
import by.korolenko.composite.service.CompositeService;
import by.korolenko.composite.service.SortService;
import by.korolenko.composite.service.factory.ServiceFactory;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public final class Controller {

    /**
     * This is command provider which contains map of commands.
     */
    private final CommandProvider provider = new CommandProvider();

    /**
     * This method gets command and does it.
     *
     * @param request request string
     * @return response
     */
    public String executeRequest(final String request) {
        String response;
        try {
            Command executionCommand = provider.getCommand(request.
                    toUpperCase());
            response = executionCommand.execute();
        } catch (IllegalArgumentException e) {
            response = "Illegal command";
        }
        return response;
    }

    /**
     * Main.
     *
     * @param args args
     */
    public static void main(final String[] args) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CompositeService compositeService = serviceFactory.
                getCompositeService();
        compositeService.add();
        SortService sortService = serviceFactory.getSortService();
        sortService.sortBySentenceCount();
        //sortService.sortByWordLength();
        compositeService.collect();
        //sortService.sortLexemeBySymbol('a');
    }
}
