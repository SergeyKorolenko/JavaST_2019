package by.korolenko.composite.service;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public interface CompositeService {
    /**
     * This method parses text.
     *
     * @return parsed text
     */
    String parse();

    /**
     * This method collects text.
     *
     * @return text
     */
    String collect();
}
