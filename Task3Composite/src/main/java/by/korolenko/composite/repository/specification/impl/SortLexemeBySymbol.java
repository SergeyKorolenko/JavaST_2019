package by.korolenko.composite.repository.specification.impl;

import by.korolenko.composite.bean.Component;
import by.korolenko.composite.bean.Composite;
import by.korolenko.composite.bean.enums.TextPart;
import by.korolenko.composite.repository.collector.ComponentCollector;
import by.korolenko.composite.repository.specification.Specification;
import by.korolenko.composite.service.comparator.LexemeComparator;
import by.korolenko.composite.service.comparator.StringComparator;

import java.util.stream.Collectors;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class SortLexemeBySymbol implements Specification {

    /**
     * Delimiter.
     */
    private static final String DELIMITER = "\n";
    /**
     * First comparator.
     */
    private LexemeComparator first;
    /**
     * Second.
     */
    private StringComparator second;

    /**
     * Constructor with parameters.
     *
     * @param newFirst  first comparator
     * @param newSecond first comparator
     */
    public SortLexemeBySymbol(final LexemeComparator newFirst,
                              final StringComparator newSecond) {
        this.first = newFirst;
        this.second = newSecond;
    }

    /**
     * This method sorts .
     *
     * @param composite composite
     * @return result string
     */
    @Override
    public String specified(final Composite composite) {
        ComponentCollector collector = new ComponentCollector();
        return collector.collectComponent(composite, TextPart.LEXEME).
                stream().map(Component::collect).
                sorted(first.thenComparing(second)).
                collect(Collectors.joining(DELIMITER));
    }
}
