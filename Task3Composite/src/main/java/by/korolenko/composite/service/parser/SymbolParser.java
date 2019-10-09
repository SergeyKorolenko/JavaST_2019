package by.korolenko.composite.service.parser;

import by.korolenko.composite.bean.TextComposite;
import by.korolenko.composite.bean.Symbol;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class SymbolParser extends Parser {

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
        char[] chars = text.toCharArray();
        for (char symbol : chars) {
            textComposite.add(new Symbol(symbol));
        }
        return textComposite;
    }

}
