package by.korolenko.composite.service.parser;

import by.korolenko.composite.bean.TextComposite;
import by.korolenko.composite.bean.WordComposite;

import java.util.ArrayList;
import java.util.List;
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
    private static final String WORD_REGEX = "[!,\\.+\\?]+";
    /**
     * Lexeme parser.
     */
    private Parser symbolParser;

    /**
     * Constructor.
     */
    public WordParser() {
        this.symbolParser = new SymbolParser();
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
        List<String> stringList = new ArrayList<>();
        Pattern pattern = Pattern.compile(WORD_REGEX);
        Matcher matcher = pattern.matcher(text);
        if (!matcher.find()) {
            stringList.add(text);
        } else {
            stringList.add(text.substring(0, matcher.start()));
            stringList.add(matcher.group());
        }
        for (String line : stringList) {
            TextComposite word = new WordComposite();
            word = symbolParser.parse(word, line);
            textComposite.add(word);
        }
        return textComposite;
    }
}
