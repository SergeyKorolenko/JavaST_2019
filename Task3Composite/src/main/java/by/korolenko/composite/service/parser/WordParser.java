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
public class WordParser extends Parser {
    /**
     * Paragraph regex.
     */
    private static final String
            WORD_REGEX = "[\\d()\\|\\^~\\&><]+|[\\w-']+|[^\\s\\w]+";

    /**
     * Expression regex.
     */
    private static final String EXPRESSION_REGEX = "[\\d()\\|\\^~\\&><]{2,}";

    /**
     * Parser.
     *
     * @param text text
     * @return composite
     */
    @Override
    public Composite parse(final String text) {
        Composite composite = new Composite(TextPart.WORD);
        Pattern pattern = Pattern.compile(WORD_REGEX);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            composite.add(getNextParser().parse(matcher.group()));
        }
        return composite;
    }
}
