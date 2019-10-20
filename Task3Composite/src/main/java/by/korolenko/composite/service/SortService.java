package by.korolenko.composite.service;

public interface SortService {
    /**
     * Sort.
     *
     * @return response
     */
    String sortBySentenceCount();

    /**
     * Sort.
     *
     * @return response
     */
    String sortByWordLength();

    /**
     * Sort.
     *
     * @param symbol s
     * @return response
     */
    String sortLexemeBySymbol(char symbol);
}
