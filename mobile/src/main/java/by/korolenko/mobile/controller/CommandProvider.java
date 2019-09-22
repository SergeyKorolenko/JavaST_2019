package by.korolenko.mobile.controller;

import by.korolenko.mobile.controller.command.Command;
import by.korolenko.mobile.controller.command.CommandName;
import by.korolenko.mobile.controller.command.impl.AddTariff;
import by.korolenko.mobile.controller.command.impl.DeleteTariff;
import by.korolenko.mobile.controller.command.impl.FindBetweenId;
import by.korolenko.mobile.controller.command.impl.FindById;
import by.korolenko.mobile.controller.command.impl.FindByName;
import by.korolenko.mobile.controller.command.impl.GetAllTariff;
import by.korolenko.mobile.controller.command.impl.ReadFromFile;
import by.korolenko.mobile.controller.command.impl.SortById;
import by.korolenko.mobile.controller.command.impl.SortByIdAndName;
import by.korolenko.mobile.controller.command.impl.SortByName;
import by.korolenko.mobile.controller.command.impl.UpdateTariff;
import by.korolenko.mobile.controller.command.impl.WriteToFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
final class CommandProvider {
    /**
     * This is the map of commands.
     */
    private final Map<CommandName, Command> commandStorage = new HashMap<>();

    /**
     * This is the command provider.
     */
    CommandProvider() {
        commandStorage.put(CommandName.ADD_TARIFF, new AddTariff());
        commandStorage.put(CommandName.GET_ALL, new GetAllTariff());
        commandStorage.put(CommandName.READ_FROM_FILE, new ReadFromFile());
        commandStorage.put(CommandName.DELETE_TARIFF, new DeleteTariff());
        commandStorage.put(CommandName.UPDATE_TARIFF, new UpdateTariff());
        commandStorage.put(CommandName.SORT_BY_ID, new SortById());
        commandStorage.put(CommandName.SORT_BY_NAME, new SortByName());
        commandStorage.put(CommandName.FIND_BY_ID, new FindById());
        commandStorage.put(CommandName.FIND_BY_NAME, new FindByName());
        commandStorage.put(CommandName.FIND_BETWEEN_ID, new FindBetweenId());
        commandStorage.put(CommandName.SORT_BY_ID_AND_NAME,
                new SortByIdAndName());
        commandStorage.put(CommandName.WRITE_TO_FILE, new WriteToFile());
    }

    /**
     * This method is for getting any command.
     *
     * @param name name
     * @return any command
     * @throws IllegalArgumentException exception
     */
    Command getCommand(final String name) throws IllegalArgumentException {
        Command command = null;
        CommandName commandName = CommandName.valueOf(name.toUpperCase());
        command = commandStorage.get(commandName);
        return command;
    }
}
