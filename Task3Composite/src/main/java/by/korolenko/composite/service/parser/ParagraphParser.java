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
public class ParagraphParser extends Parser {
    /**
     * Paragraph regex.
     */
    private static final String PARAGRAPH_REGEX = "[\\S].+";

    /**
     * This method parses text to paragraphs.
     *
     * @param text text
     * @return composite
     */
    @Override
    public Composite parse(final String text) {
        Composite composite = new Composite(TextPart.PARAGRAPH);
        Pattern pattern = Pattern.compile(PARAGRAPH_REGEX);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            composite.add(nextParser.parse(matcher.group()));
        }
        return composite;
    }
}
