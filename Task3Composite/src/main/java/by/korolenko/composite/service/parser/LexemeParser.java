package by.korolenko.composite.service.parser;

import by.korolenko.composite.bean.Composite;

import java.util.Arrays;
import java.util.List;

public class LexemeParser extends Parser {

    /**
     * Word parser.
     */
    private Parser wordParser;

    /**
     * Constructor.
     */
    public LexemeParser() {
        this.wordParser = new WordParser();
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
        List<String> stringList = Arrays.asList(text.split(" "));
        for (String line : stringList) {
            System.out.println("Lexeme");
            Composite lexeme = new Composite();
            System.out.println(line);
            //sentence.add(new Sentence(line));
            lexeme = wordParser.parse(lexeme, line);
            composite.add(lexeme);
        }
        return composite;
    }
}
