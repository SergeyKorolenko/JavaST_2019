package by.korolenko.composite.service.parser;

import by.korolenko.composite.bean.TextComposite;
import by.korolenko.composite.bean.SentenceTextComposite;

import java.util.Arrays;
import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class SentenceParser extends Parser {

    /**
     * Paragraph regex.
     */
    private static final String SENTENCE_REGEX = "\\.";
    /**
     * Lexeme parser.
     */
    private Parser lexemeParser;

    /**
     * Constructor.
     */
    public SentenceParser() {
        this.lexemeParser = new LexemeParser();
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
        List<String> stringList = Arrays.asList(text.split(SENTENCE_REGEX));
        for (String line : stringList) {
            TextComposite sentence = new SentenceTextComposite();
            line += ".";
            sentence = lexemeParser.parse(sentence, line.trim());
            textComposite.add(sentence);
        }
        return textComposite;
    }
}
