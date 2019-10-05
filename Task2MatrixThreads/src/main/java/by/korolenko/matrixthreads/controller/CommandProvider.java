package by.korolenko.matrixthreads.controller;

import by.korolenko.matrixthreads.controller.command.Command;
import by.korolenko.matrixthreads.controller.command.CommandName;
import by.korolenko.matrixthreads.controller.command.impl.CreateStorage;
import by.korolenko.matrixthreads.controller.command.impl.ShowStorageMatrix;
import by.korolenko.matrixthreads.controller.command.impl.UseCallable;
import by.korolenko.matrixthreads.controller.command.impl.UseLock;
import by.korolenko.matrixthreads.controller.command.impl.UsePhaser;
import by.korolenko.matrixthreads.controller.command.impl.UseSemaphore;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
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
        commandStorage.put(CommandName.SHOW_STORAGE_MATRIX,
                new ShowStorageMatrix());
        commandStorage.put(CommandName.CREATE_STORAGE, new CreateStorage());
        commandStorage.put(CommandName.LOCK, new UseLock());
        commandStorage.put(CommandName.SEMAPHORE, new UseSemaphore());
        commandStorage.put(CommandName.CALLABLE, new UseCallable());
        commandStorage.put(CommandName.PHASER, new UsePhaser());
    }

    /**
     * This method is for getting any command.
     *
     * @param name name
     * @return any command
     * @throws IllegalArgumentException exception
     */
    Command getCommand(final String name) {
        Command command;
        CommandName commandName = CommandName.valueOf(name.toUpperCase());
        command = commandStorage.get(commandName);
        return command;
    }
}
