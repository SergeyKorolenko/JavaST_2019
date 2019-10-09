package by.korolenko.composite.service.parser;

import by.korolenko.composite.bean.TextComposite;
import by.korolenko.composite.bean.ParagraphTextComposite;

import java.util.Arrays;
import java.util.List;

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
     * @param text      line
     * @return composite
     */
    @Override
    public TextComposite parse(final TextComposite textComposite,
                               final String text) {
        List<String> list = Arrays.asList(text.split(PARAGRAPH_REGEX));
        list = list.subList(1, list.size());
        for (String line : list) {
            TextComposite paragraph = new ParagraphTextComposite();
            paragraph = sentenceParser.parse(paragraph, line);
            textComposite.add(paragraph);
        }
        /*Pattern pattern = Pattern.compile(PARAGRAPH_REGEX);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.start());
            System.out.println(matcher.end());
        }*/
        return textComposite;
    }
}
