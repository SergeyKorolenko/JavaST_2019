package by.korolenko.composite.repository.impl;

import by.korolenko.composite.bean.TextComposite;
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
     * @param textComposite composite
     */
    public void add(final TextComposite textComposite) {
        storage.setTextComposite(textComposite);
    }

    /**
     * Take method.
     *
     * @return composite
     */
    public TextComposite take() {
        return storage.getTextComposite();
    }
}
