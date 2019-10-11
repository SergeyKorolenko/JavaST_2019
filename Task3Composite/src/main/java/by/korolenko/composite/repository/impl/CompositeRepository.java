package by.korolenko.composite.repository.impl;

import by.korolenko.composite.bean.Composite;
import by.korolenko.composite.bean.CompositeStorage;
import by.korolenko.composite.repository.Repository;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class CompositeRepository implements Repository {
    /**
     * Storage.
     */
    private CompositeStorage storage = CompositeStorage.getInstance();

    /**
     * Add method.
     *
     * @param composite composite
     */
    public void add(final Composite composite) {
        storage.setComposite(composite);
    }

    /**
     * Take method.
     *
     * @return composite
     */
    public Composite take() {
        return storage.getComposite();
    }
}
