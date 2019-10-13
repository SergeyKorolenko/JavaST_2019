package by.korolenko.composite.service;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public interface CompositeService {
    /**
     * Add.
     */
    void add();

    /**
     * Collect text.
     *
     * @return text
     */
    String collect();

    /**
     * Sort text.
     *
     * @return sorted text
     */
    String sortBySentence();

    /**
     * Sort text.
     *
     * @return sorted text
     */
    String sortByWordLength();
}
