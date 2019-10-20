package by.korolenko.composite.repository.specification.impl;

import by.korolenko.composite.bean.Component;
import by.korolenko.composite.bean.Composite;
import by.korolenko.composite.bean.enums.TextPart;
import by.korolenko.composite.repository.collector.ComponentCollector;
import by.korolenko.composite.repository.specification.Specification;
import by.korolenko.composite.service.comparator.SentenceComparator;

import java.util.stream.Collectors;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class SortParagraphBySentenceCount implements Specification {

    /**
     * Delimiter.
     */
    private static final String DELIMITER = "\n";
    /**
     * Comparator.
     */
    private SentenceComparator comparator;

    /**
     * Constructor.
     *
     * @param newComparator comparator
     */
    public SortParagraphBySentenceCount(
            final SentenceComparator newComparator) {
        this.comparator = newComparator;
    }

    /**
     * This is the specified method.
     *
     * @param composite composite
     * @return result string
     */
    public String specified(final Composite composite) {
        ComponentCollector collector = new ComponentCollector();
        return collector.collectComponent(composite, TextPart.PARAGRAPH).
                stream().sorted(comparator).map(Component::collect).
                collect(Collectors.joining(DELIMITER));
    }
}
