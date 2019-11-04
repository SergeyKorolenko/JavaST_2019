package by.korolenko.xml.controller.command;

import by.korolenko.xml.bean.GemType;

import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 29.10.2019
 */
public interface Command {
    /**
     * This is the signature of command method.
     *
     * @param request request
     * @return response string
     */
    List<GemType> execute(String request);
}
