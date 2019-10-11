package by.korolenko.composite.service.parser;

import by.korolenko.composite.bean.Composite;
import by.korolenko.composite.bean.Sentence;

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
    private static final String SENTENCE_REGEX = "[!?.]+[ \\r]*";

    /**
     * Parse method.
     *
     * @param composite composite
     * @param text      line
     * @return composite
     */
    @Override
    public Composite parse(final Composite composite,
                           final String text) {
        String[] list = text.split(SENTENCE_REGEX);
        List<String> stringList = new ArrayList<>();
        Pattern pattern = Pattern.compile(SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(text);
        int i = 0;
        while (matcher.find()) {
            stringList.add(list[i] + text.substring(matcher.start(),
                    matcher.start() + 1));
            i++;
        }
        for (String line : stringList) {
            Composite sentence = new Sentence();
            sentence = getNextParser().parse(sentence, line.trim());
            composite.add(sentence);
        }
        return composite;
    }
}
