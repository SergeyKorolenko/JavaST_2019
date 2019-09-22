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
public class SortByOneParam implements Specification<Tariff> {

    /**
     * Comparator by id.
     */
    private Comparator<Tariff> comparator;

    /**
     * This is constructor.
     *
     * @param newComparator comparator
     */
    public SortByOneParam(final Comparator<Tariff> newComparator) {
        this.comparator = newComparator;
    }

    /**
     * This method sorts list by id.
     *
     * @param list list to be sorted
     * @return sorted list
     */
    @Override
    public List<Tariff> specified(final List<Tariff> list) {
        return list.stream().sorted(comparator).
                collect(Collectors.toList());
    }
}
