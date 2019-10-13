package by.korolenko.composite.service.parser;

import by.korolenko.composite.bean.Composite;
import by.korolenko.composite.bean.enums.TextPart;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class LexemeParser extends Parser {

    /**
     * Paragraph regex.
     */
    private static final String LEXEME_REGEX = "[ \\r]+";

    /**
     * Parse method.
     *
     * @param composite composite
     * @param text      line
     * @return composite
     */
    @Override
    public Composite parse(final Composite composite,
                           final String text) {
        String[] stringList = text.split(LEXEME_REGEX);
        for (String line : stringList) {
            Composite lexeme = new Composite(TextPart.LEXEME);
            lexeme = getNextParser().parse(lexeme, line);
            composite.add(lexeme);
        }
        return composite;
    }
}
