package by.korolenko.composite.service.parser;

import by.korolenko.composite.bean.Composite;

public abstract class Parser {

    /**
     * Parsing method.
     *
     * @param composite composite
     * @param text      line
     * @return composite
     */
    public abstract Composite parse(Composite composite, String text);
}
