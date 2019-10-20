package by.korolenko.composite.service.impl;

import by.korolenko.composite.repository.Repository;
import by.korolenko.composite.repository.impl.CompositeRepository;
import by.korolenko.composite.repository.specification.impl.SortLexemeBySymbol;
import by.korolenko.composite.repository.specification.impl.SortParagraphBySentenceCount;
import by.korolenko.composite.repository.specification.impl.SortSentenceByWordLength;
import by.korolenko.composite.service.SortService;
import by.korolenko.composite.service.comparator.LexemeComparator;
import by.korolenko.composite.service.comparator.SentenceComparator;
import by.korolenko.composite.service.comparator.StringComparator;
import by.korolenko.composite.service.comparator.WordLengthComparator;

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
        String result = repository.query(new SortParagraphBySentenceCount(
                new SentenceComparator()));
        System.out.println(result);
        return null;
    }

    /**
     * Sort.
     *
     * @return response
     */
    @Override
    public String sortByWordLength() {
        String result = repository.query(new SortSentenceByWordLength(
                new WordLengthComparator()));
        System.out.println(result);
        return null;
    }

    /**
     * Sort.
     *
     * @param symbol s
     * @return response
     */
    @Override
    public String sortLexemeBySymbol(final char symbol) {
        String result = repository.query(new SortLexemeBySymbol(
                new LexemeComparator(symbol), new StringComparator()));
        System.out.println(result);
        return null;
    }
}
