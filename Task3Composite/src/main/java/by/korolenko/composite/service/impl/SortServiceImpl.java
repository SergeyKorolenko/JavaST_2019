package by.korolenko.composite.service.impl;

import by.korolenko.composite.repository.Repository;
import by.korolenko.composite.repository.impl.CompositeRepository;
import by.korolenko.composite.repository.specification.impl.SortLexemeBySymbol;
import by.korolenko.composite.repository.specification.impl.SortParagraphBySentenceCount;
import by.korolenko.composite.repository.specification.impl.SortSentenceByWordLength;
import by.korolenko.composite.service.SortService;
import by.korolenko.composite.service.comparator.LexemeComparator;
import by.korolenko.composite.service.comparator.CompositeSizeComparator;
import by.korolenko.composite.service.comparator.StringComparator;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class SortServiceImpl implements SortService {

    /**
     * Repository.
     */
    private Repository repository = new CompositeRepository();

    /**
     * Sort.
     *
     * @return response
     */
    @Override
    public String sortBySentenceCount() {
        return repository.doAction(new SortParagraphBySentenceCount(
                new CompositeSizeComparator()));
    }

    /**
     * Sort.
     *
     * @return response
     */
    @Override
    public String sortByWordLength() {
        return repository.doAction(new SortSentenceByWordLength(
                new CompositeSizeComparator()));
    }

    /**
     * Sort.
     *
     * @param symbol s
     * @return response
     */
    @Override
    public String sortLexemeBySymbol(final char symbol) {
        return repository.doAction(new SortLexemeBySymbol(
                new LexemeComparator(symbol), new StringComparator()));
    }
}
