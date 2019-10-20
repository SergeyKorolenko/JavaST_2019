package by.korolenko.composite.controller;

import by.korolenko.composite.controller.command.Command;
import by.korolenko.composite.view.Menu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
     * Delimiter.
     */
    private static final String DELIMITER = ",";
    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(Controller.class.getName());
    /**
     * This method gets command and does it.
     *
     * @param request request string
     * @return response
     */
    public String executeRequest(final String request) {
        String response;
        try {
            String commandName = request.substring(0, request.
                    indexOf(DELIMITER));
            String newRequest = request.substring(commandName.length() + 1);
            Command executionCommand = provider.getCommand(commandName.
                    toUpperCase());
            response = executionCommand.execute(newRequest);
        } catch (IllegalArgumentException e) {
            LOGGER.error("Incorrect command", e);
            response = "Illegal command";
        } catch (StringIndexOutOfBoundsException e) {
            LOGGER.error("Request string error", e);
            response = "Request string error";
        }
        return response;
    }

    /**
     * Main method.
     *
     * @param args args
     */
    public static void main(final String[] args) {
        Menu menu = new Menu();
        menu.start();
    }
}
