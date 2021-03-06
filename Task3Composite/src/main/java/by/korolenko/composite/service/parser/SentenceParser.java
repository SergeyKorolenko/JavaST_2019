package by.korolenko.composite.service.parser;

import by.korolenko.composite.bean.Composite;
import by.korolenko.composite.bean.enums.TextPart;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class SentenceParser extends Parser {

    /**
     * Sentence regex.
     */
    private static final String SENTENCE_REGEX = "[\\S][^.!?]+[.!?]+";

    /**
     * This method parses text to sentences.
     *
     * @param text text
     * @return composite
     */
    @Override
    public Composite parse(final String text) {
        Composite composite = new Composite(TextPart.SENTENCE);
        Pattern pattern = Pattern.compile(SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            composite.add(nextParser.parse(matcher.group()));
        }
        return composite;
    }
}
