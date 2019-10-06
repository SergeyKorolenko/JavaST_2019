package by.korolenko.matrixthreads.controller;

import by.korolenko.matrixthreads.controller.command.Command;
import by.korolenko.matrixthreads.view.Menu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public final class Controller {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(Controller.class.getName());
    /**
     * This is command provider which contains map of commands.
     */
    private final CommandProvider provider = new CommandProvider();

    /**
     * This method takes the query string and executes it.
     *
     * @param request the request string
     * @return response as a string
     */
    public String executeRequest(final String request) {
        String response;
        try {
            Command executionCommand = provider.getCommand(request);
            response = executionCommand.execute();
        } catch (IllegalArgumentException e) {
            LOGGER.error("incorrect command", e);
            response = "Incorrect command.";
        }
        return response;
    }
    /**
     * This is the main method.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        Menu menu = new Menu();
        menu.start();
    }
}
