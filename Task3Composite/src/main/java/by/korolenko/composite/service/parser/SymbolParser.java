package by.korolenko.composite.service.parser;

import by.korolenko.composite.bean.Composite;
import by.korolenko.composite.bean.Symbol;

public class SymbolParser extends Parser {

    /**
     * Parse method.
     *
     * @param composite composite
     * @param text      line
     * @return composite
     */
    @Override
    public Composite parse(final Composite composite, final String text) {
        char[] chars = text.toCharArray();
        for (char symbol : chars) {
            System.out.println("Symbol");
            System.out.println(symbol);
            //sentence.add(new Sentence(line));
            composite.add(new Symbol(symbol));
        }
        return composite;
    }

}
