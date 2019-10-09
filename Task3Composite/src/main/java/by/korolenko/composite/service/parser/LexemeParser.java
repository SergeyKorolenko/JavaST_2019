package by.korolenko.composite.service.parser;

import by.korolenko.composite.bean.LexemeComposite;
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
     * @param textComposite composite
     * @param text      line
     * @return composite
     */
    @Override
    public TextComposite parse(final TextComposite textComposite,
                               final String text) {
        String[] stringList = text.split(LEXEME_REGEX);
        for (String line : stringList) {
            TextComposite lexeme = new LexemeComposite();
            lexeme = wordParser.parse(lexeme, line);
            textComposite.add(lexeme);
        }
        return textComposite;
    }
}
