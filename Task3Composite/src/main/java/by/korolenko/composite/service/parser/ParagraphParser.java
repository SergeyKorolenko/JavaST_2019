package by.korolenko.composite.service.parser;

import by.korolenko.composite.bean.Composite;
import by.korolenko.composite.bean.Paragraph;

import java.util.Arrays;
import java.util.List;

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
     * @param composite composite
     * @param text      line
     * @return composite
     */
    @Override
    public Composite parse(final Composite composite, final String text) {
        List<String> list = Arrays.asList(text.split(PARAGRAPH_REGEX));
        list = list.subList(1, list.size());
        for (String line : list) {
            Composite paragraph = new Paragraph();
            paragraph = sentenceParser.parse(paragraph, line);
            composite.add(paragraph);
        }
        return composite;
    }
}
