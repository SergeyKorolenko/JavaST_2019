package by.korolenko.matrixthreads.controller.command;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public interface Command {
    /**
     * This is the signature of command method.
     *
     * @return response string
     */
    String execute();
}
