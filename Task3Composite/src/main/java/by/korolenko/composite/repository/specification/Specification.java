package by.korolenko.composite.repository.specification;

import by.korolenko.composite.bean.Composite;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public interface Specification {
    /**
     * This is the specified method.
     *
     * @param composite composite
     * @return result string
     */
    String specified(Composite composite);
}
