package by.korolenko.composite.service.parser;

import by.korolenko.composite.bean.TextComposite;
import by.korolenko.composite.bean.SentenceComposite;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class SentenceParser extends Parser {

    /**
     * Paragraph regex.
     */
    private static final String SENTENCE_REGEX = "[!\\?\\.] ";
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
     * @param text          line
     * @return composite
     */
    @Override
    public TextComposite parse(final TextComposite textComposite,
                               final String text) {
        String[] list = text.split(SENTENCE_REGEX);
        List<String> stringList = new ArrayList<>();
        Pattern pattern = Pattern.compile(SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(text);
        int i = 0;
        while (matcher.find() && i < list.length - 1) {
            stringList.add(list[i] + text.substring(matcher.start(),
                    matcher.end() - 1));
        }
        stringList.add(list[list.length - 1]);
        for (String line : stringList) {
            TextComposite sentence = new SentenceComposite();
            sentence = lexemeParser.parse(sentence, line.trim());
            textComposite.add(sentence);
        }
        return textComposite;
    }
}
