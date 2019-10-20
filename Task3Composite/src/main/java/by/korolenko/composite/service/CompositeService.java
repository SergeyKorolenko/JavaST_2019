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
    void parse();

    /**
     * This method collects text.
     *
     * @return text
     */
    String collect();
}
