package by.korolenko.composite.service.parser;

import by.korolenko.composite.bean.TextComposite;
import by.korolenko.composite.bean.WordTextComposite;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class WordParser extends Parser {
    /**
     * Paragraph regex.
     */
    private static final String WORD_REGEX = " ";
    /**
     * Lexeme parser.
     */
    private Parser symbolParser;

    /**
     * Constructor.
     */
    public WordParser() {
        this.symbolParser = new SymbolParser();
    }

    /**
     * Parse method.
     *
     * @param textComposite composite
     * @param text      line
     * @return composite
     */
    @Override
    public TextComposite parse(final TextComposite textComposite,
                               final String text) {
        String[] stringList = text.split(WORD_REGEX);
        for (String line : stringList) {
            TextComposite word = new WordTextComposite();
            word = symbolParser.parse(word, line);
            textComposite.add(word);
        }
        return textComposite;
    }
}
