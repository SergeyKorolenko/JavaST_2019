package by.korolenko.composite.repository.specification.impl;

import by.korolenko.composite.bean.Component;
import by.korolenko.composite.bean.Composite;
import by.korolenko.composite.bean.enums.TextPart;
import by.korolenko.composite.repository.collector.ComponentCollector;
import by.korolenko.composite.repository.specification.Specification;

import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class SortSentenceByWordLength implements Specification {

    /**
     * Enter.
     */
    private static final String ENTER = "\n";
    /**
     * Space.
     */
    private static final String SPACE = " ";
    /**
     * Comparator.
     */
    private Comparator<Component> comparator;

    /**
     * Constructor.
     *
     * @param newComparator comparator
     */
    public SortSentenceByWordLength(
            final Comparator<Component> newComparator) {
        this.comparator = newComparator;
    }

    /**
     * This is the specified method.
     *
     * @param composite composite
     * @return result string
     */
    @Override
    public String specified(final Composite composite) {
        ComponentCollector collector = new ComponentCollector();
        return collector.collectComponent(composite, TextPart.SENTENCE).
                stream().map(c -> collector.collectComponent((Composite) c,
                TextPart.WORD)).map(c -> c.stream().sorted(comparator).
                collect(Collectors.toList())).map(c -> c.stream().
                map(Component::collect).collect(Collectors.
                joining(SPACE))).
                collect(Collectors.joining(ENTER));
    }
}
