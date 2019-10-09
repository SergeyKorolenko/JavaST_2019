package by.korolenko.composite.service.parser;

import by.korolenko.composite.bean.TextComposite;
import by.korolenko.composite.bean.ParagraphComposite;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class ParagraphParser extends Parser {

    /**
     * Paragraph regex.
     */
    private static final String PARAGRAPH_REGEX = " {4}";

    /**
     * Sentence parser.
     */
    private Parser sentenceParser;

    /**
     * Constructor.
     */
    public ParagraphParser() {
        this.sentenceParser = new SentenceParser();
    }

    /**
     * Parse method.
     *
     * @param textComposite composite
     * @param text          line
     * @return composite
     */
    @Override
    public TextComposite parse(final TextComposite textComposite,
                               final String text) {

        String[] list = text.trim().split(PARAGRAPH_REGEX);
        for (String line : list) {
            TextComposite paragraph = new ParagraphComposite();
            paragraph = sentenceParser.parse(paragraph, line);
            textComposite.add(paragraph);
        }
        return textComposite;
    }
}
