package by.korolenko.composite.service.parser;

import by.korolenko.composite.bean.Composite;
import by.korolenko.composite.bean.Symbol;
import by.korolenko.composite.bean.enums.TextPart;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class SymbolParser extends Parser {

    /**
     * This method parses text to symbols.
     *
     * @param text text
     * @return composite
     */
    @Override
    public Composite parse(final String text) {
        Composite composite = new Composite(TextPart.SYMBOL);
        char[] chars = text.toCharArray();
        for (char symbol : chars) {
            composite.add(new Symbol(symbol));
        }
        return composite;
    }

}
