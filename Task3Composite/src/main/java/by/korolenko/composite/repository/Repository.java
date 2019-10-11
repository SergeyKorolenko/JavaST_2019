package by.korolenko.composite.repository;

import by.korolenko.composite.bean.Composite;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public interface Repository {
    /**
     * Add method.
     *
     * @param composite composite
     */
    void add(Composite composite);

    /**
     * Take method.
     *
     * @return composite
     */
    Composite take();
}
