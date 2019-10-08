package by.korolenko.composite.repository;

import by.korolenko.composite.bean.Composite;

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
