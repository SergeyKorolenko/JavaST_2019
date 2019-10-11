package by.korolenko.composite.service.parser;

import by.korolenko.composite.bean.Composite;
import by.korolenko.composite.bean.Word;

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
    private static final String WORD_REGEX = "[!,.?:;'\"\\n]+";

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
        List<String> stringList = new ArrayList<>();
        Pattern pattern = Pattern.compile(WORD_REGEX);
        Matcher matcher = pattern.matcher(text);
        String[] split = text.split(WORD_REGEX);
        if (split.length == 1 && split[0].length() == text.length()) {
            stringList.add(text);
        } else if (split.length == 2 && split[1].length() + 1
                != text.length()) {
            matcher.find();
            stringList.add(text.substring(matcher.start(),
                    matcher.end() + 1));
            int start = matcher.end() + 1;
            matcher.find();
            stringList.add(text.substring(start, matcher.start()));
            stringList.add(text.substring(matcher.start()));
        } else {
            matcher.find();
            stringList.add(text.substring(0, matcher.start()));
            stringList.add(text.substring(matcher.start()));
        }
        for (String line : stringList) {
            Composite word = new Word();
            word = getNextParser().parse(word, line);
            composite.add(word);
        }
        return composite;
    }
}
