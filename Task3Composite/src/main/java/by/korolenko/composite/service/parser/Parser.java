package by.korolenko.composite.service.parser;

import by.korolenko.composite.bean.TextComposite;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public abstract class Parser {

    /**
     * Parsing method.
     *
     * @param textComposite composite
     * @param text      line
     * @return composite
     */
    public abstract TextComposite parse(TextComposite textComposite,
                                        String text);
}
