package by.korolenko.composite.service.parser;

import by.korolenko.composite.bean.Composite;

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
        System.out.println(stringList.size());
        for (String line : stringList) {
            System.out.println("Sentence");
            Composite sentence = new Composite();
            System.out.println(line);
            //sentence.add(new Sentence(line));
            sentence = lexemeParser.parse(sentence, line);
            composite.add(sentence);
        }
        return composite;
    }
}
