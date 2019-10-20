package by.korolenko.composite.repository.impl;

import by.korolenko.composite.bean.Composite;
import by.korolenko.composite.bean.CompositeStorage;
import by.korolenko.composite.repository.Repository;
import by.korolenko.composite.repository.specification.Specification;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class CompositeRepository implements Repository {
    /**
     * Composite storage.
     */
    private CompositeStorage storage = CompositeStorage.getInstance();

    /**
     * This method adds composite to the storage.
     *
     * @param composite composite
     */
    public void addComposite(final Composite composite) {
        storage.setComposite(composite);
    }

    /**
     * This method returns composite.
     *
     * @return composite
     */
    public Composite getComposite() {
        return storage.getComposite();
    }

    /**
     * Query.
     *
     * @param specification specification
     * @return response
     */
    @Override
    public String doAction(final Specification specification) {
        return specification.specified(storage.getComposite());
    }
}
