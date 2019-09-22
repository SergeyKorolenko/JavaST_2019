package by.korolenko.mobile.controller.command;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public interface Command {
    /**
     * This is the signature of command method.
     *
     * @param request request string
     * @return response string
     */
    String execute(String request);
}
