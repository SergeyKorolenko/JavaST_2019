package by.korolenko.composite.controller.command;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public interface Command {

    /**
     * This is the signature of command method.
     *
     * @param request request
     * @return response string
     */
    String execute(String request);
}
