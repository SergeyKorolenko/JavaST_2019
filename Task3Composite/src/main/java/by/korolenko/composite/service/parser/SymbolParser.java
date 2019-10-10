package by.korolenko.composite.service.parser;

import by.korolenko.composite.bean.TextComposite;
import by.korolenko.composite.bean.StringLeaf;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class SymbolParser extends Parser {

    /**
     * Parse method.
     *
     * @param composite composite
     * @param text      line
     * @return composite
     */
    @Override
    public TextComposite parse(final TextComposite composite,
                               final String text) {
        char[] chars = text.toCharArray();
        for (char symbol : chars) {
            composite.add(new StringLeaf(Character.toString(symbol)));
        }
        return composite;
    }

}
