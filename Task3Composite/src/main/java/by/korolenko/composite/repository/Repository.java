package by.korolenko.composite.repository;

import by.korolenko.composite.bean.TextComposite;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public interface Repository {
    /**
     * Add method.
     *
     * @param textComposite composite
     */
    void add(TextComposite textComposite);

    /**
     * Take method.
     *
     * @return composite
     */
    TextComposite take();
}
