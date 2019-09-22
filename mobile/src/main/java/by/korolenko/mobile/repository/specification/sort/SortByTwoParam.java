package by.korolenko.mobile.repository.specification.sort;

import by.korolenko.mobile.bean.Tariff;
import by.korolenko.mobile.repository.specification.Specification;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public class SortByTwoParam implements Specification<Tariff> {

    /**
     * This is the first comparator.
     */
    private Comparator<Tariff> first;
    /**
     * This is the second comparator.
     */
    private Comparator<Tariff> second;

    /**
     * This is the constructor with parameters.
     *
     * @param newFirst  first comparator
     * @param newSecond second comparator
     */
    public SortByTwoParam(final Comparator<Tariff> newFirst,
                          final Comparator<Tariff> newSecond) {
        this.first = newFirst;
        this.second = newSecond;
    }

    /**
     * This method sorts list by two params.
     *
     * @param list list to be sorted
     * @return sorted list
     */
    @Override
    public List<Tariff> specified(final List<Tariff> list) {
        return list.stream().sorted(first.thenComparing(second)).
                collect(Collectors.toList());
    }
}
