package by.korolenko.composite.service.parser;

import by.korolenko.composite.bean.Composite;

import java.util.Arrays;
import java.util.List;

public class WordParser extends Parser {
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
     * @param composite composite
     * @param text      line
     * @return composite
     */
    @Override
    public Composite parse(final Composite composite, final String text) {
        List<String> stringList = Arrays.asList(text.split(" "));
        for (String line : stringList) {
            System.out.println("Word");
            Composite word = new Composite();
            System.out.println(line);
            //sentence.add(new Sentence(line));
            word = symbolParser.parse(word, line);
            composite.add(word);
        }
        return composite;
    }
}
