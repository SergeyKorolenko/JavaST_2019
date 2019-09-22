package by.korolenko.mobile.controller;

import by.korolenko.mobile.controller.command.Command;
import by.korolenko.mobile.view.Menu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public final class Controller {
    /**
     * This is command provider which contains map of commands.
     */
    private final CommandProvider provider = new CommandProvider();
    /**
     * This is delimiter.
     */
    private static final String DELIMITER = ",";
    /**
     * Logger.
     */
    private final Logger log = LogManager.getLogger(Controller.class.getName());

    /**
     * This method takes the query string and executes it.
     *
     * @param request the request string
     * @return response as a string
     */
    public String executeRequest(final String request) {
        String response;
        try {
            String commandName = request.substring(0, request.
                    indexOf(DELIMITER));
            String newRequest = request.substring(commandName.length() + 1);
            Command executionCommand = provider.getCommand(commandName);
            response = executionCommand.execute(newRequest);
        } catch (IllegalArgumentException e) {
            log.error("No such command : ", e);
            response = "Incorrect command.";
        } catch (StringIndexOutOfBoundsException e) {
            log.error("Request error", e);
            response = "Incorrect request.";
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
