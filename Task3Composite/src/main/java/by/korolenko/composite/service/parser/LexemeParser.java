package by.korolenko.composite.service.parser;

import by.korolenko.composite.bean.Composite;
import by.korolenko.composite.bean.Lexeme;

public class LexemeParser extends Parser {

    /**
     * Word parser.
     */
    private Parser wordParser;

    /**
     * Constructor.
     */
    public LexemeParser() {
        this.wordParser = new WordParser();
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
            Composite lexeme = new Lexeme();
            lexeme = wordParser.parse(lexeme, line);
            composite.add(lexeme);
        }
        return composite;
    }
}
