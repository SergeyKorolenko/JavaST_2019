package by.korolenko.composite.service.parser;

import by.korolenko.composite.bean.Composite;
import by.korolenko.composite.bean.Sentence;

import java.util.Arrays;
import java.util.List;

public class SentenceParser extends Parser {

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
     * @param composite composite
     * @param text      line
     * @return composite
     */
    @Override
    public Composite parse(final Composite composite, final String text) {
        List<String> stringList = Arrays.asList(text.split("\\."));
        for (String line : stringList) {
            Composite sentence = new Sentence();
            sentence = lexemeParser.parse(sentence, line);
            composite.add(sentence);
        }
        return composite;
    }
}
