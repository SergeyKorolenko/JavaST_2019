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
public class LexemeParser extends Parser {

    /**
     * Lexeme regex.
     */
    private static final String LEXEME_REGEX = "[^\\s]+";

    /**
     * This method parses text to lexemes.
     *
     * @param text text
     * @return composite
     */
    @Override
    public Composite parse(final String text) {
        Composite composite = new Composite(TextPart.LEXEME);
        Pattern pattern = Pattern.compile(LEXEME_REGEX);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            composite.add(nextParser.parse(matcher.group()));
        }
        return composite;
    }
}
