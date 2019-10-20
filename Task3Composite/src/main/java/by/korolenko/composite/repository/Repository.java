package by.korolenko.composite.repository;

import by.korolenko.composite.bean.Composite;
import by.korolenko.composite.repository.specification.Specification;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public interface Repository {
    /**
     * This method adds composite to the storage.
     *
     * @param composite composite
     */
    void addComposite(Composite composite);

    /**
     * Getter for composite.
     *
     * @return composite
     */
    Composite getComposite();

    /**
     * Query method.
     *
     * @param specification specification
     * @return response
     */
    String doAction(Specification specification);
}
