package by.korolenko.composite.service.parser;

import by.korolenko.composite.bean.Composite;
import by.korolenko.composite.bean.Word;

public class WordParser extends Parser {
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
     * @param composite composite
     * @param text      line
     * @return composite
     */
    @Override
    public Composite parse(final Composite composite, final String text) {
        String[] stringList = text.split(" ");
        for (String line : stringList) {
            Composite word = new Word();
            word = symbolParser.parse(word, line);
            composite.add(word);
        }
        return composite;
    }
}
