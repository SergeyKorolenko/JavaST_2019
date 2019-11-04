package by.korolenko.xml.controller;

import by.korolenko.xml.controller.command.Command;
import by.korolenko.xml.controller.command.CommandName;
import by.korolenko.xml.controller.command.impl.DOMCommand;
import by.korolenko.xml.controller.command.impl.SAXCommand;
import by.korolenko.xml.controller.command.impl.StAXCommand;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 29.10.2019
 */
public class CommandProvider {

    /**
     * This is the map of commands.
     */
    private final Map<CommandName, Command> commandStorage = new HashMap<>();

    /**
     * Constructor.
     */
    CommandProvider() {
        commandStorage.put(CommandName.DOM, new DOMCommand());
        commandStorage.put(CommandName.SAX, new SAXCommand());
        commandStorage.put(CommandName.STAX, new StAXCommand());
    }

    /**
     * This method is for getting any command.
     *
     * @param name name
     * @return any command
     */
    Command getCommand(final String name) {
        return commandStorage.get(CommandName.valueOf(name.toUpperCase()));
    }
}
