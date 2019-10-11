package by.korolenko.composite.service.parser;

import by.korolenko.composite.bean.Composite;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public abstract class Parser {

    /**
     * Parser.
     */
    private Parser nextParser;

    /**
     * Getter for parser.
     *
     * @return parser
     */
    public Parser getNextParser() {
        return nextParser;
    }

    /**
     * Setter for parser.
     *
     * @param newNextParser next parser.
     */
    public void setNextParser(final Parser newNextParser) {
        this.nextParser = newNextParser;
    }

    /**
     * Parsing method.
     *
     * @param composite composite
     * @param text          line
     * @return composite
     */
    public abstract Composite parse(Composite composite,
                                    String text);
}
