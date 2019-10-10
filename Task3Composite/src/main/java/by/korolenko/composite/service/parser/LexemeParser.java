package by.korolenko.composite.service.parser;

import by.korolenko.composite.bean.LexemeComposite;
import by.korolenko.composite.bean.StringLeaf;
import by.korolenko.composite.bean.TextComposite;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class LexemeParser extends Parser {

    /**
     * Paragraph regex.
     */
    private static final String LEXEME_REGEX = " ";

    /**
     * Parse method.
     *
     * @param composite composite
     * @param text      line
     * @return composite
     */
    @Override
    public TextComposite parse(final TextComposite composite,
                               final String text) {
        String[] stringList = text.split(LEXEME_REGEX);
        for (String line : stringList) {
            TextComposite lexeme = new LexemeComposite();
            if (getNextParser() == null) {
                lexeme.add(new StringLeaf(line));
            } else {
                lexeme = getNextParser().parse(lexeme, line);
            }
            composite.add(lexeme);
        }
        return composite;
    }
}
