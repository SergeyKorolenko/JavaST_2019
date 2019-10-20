package by.korolenko.composite.controller;

import by.korolenko.composite.controller.command.Command;
import by.korolenko.composite.controller.command.CommandName;
import by.korolenko.composite.controller.command.impl.CollectText;
import by.korolenko.composite.controller.command.impl.ParseText;
import by.korolenko.composite.controller.command.impl.SortBySentenceCount;
import by.korolenko.composite.controller.command.impl.SortBySymbol;
import by.korolenko.composite.controller.command.impl.SortByWordLength;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
final class CommandProvider {
    /**
     * This is the map of commands.
     */
    private final Map<CommandName, Command> commandStorage = new HashMap<>();

    /**
     * Constructor.
     */
    CommandProvider() {
        commandStorage.put(CommandName.PARSE_TEXT, new ParseText());
        commandStorage.put(CommandName.COLLECT_TEXT, new CollectText());
        commandStorage.put(CommandName.SORT_BY_SENTENCE_COUNT,
                new SortBySentenceCount());
        commandStorage.put(CommandName.SORT_BY_WORD_LENGTH,
                new SortByWordLength());
        commandStorage.put(CommandName.SORT_LEXEME_BY_SYMBOL,
                new SortBySymbol());
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
