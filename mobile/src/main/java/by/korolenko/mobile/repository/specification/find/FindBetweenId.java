package by.korolenko.mobile.repository.specification.find;

import by.korolenko.mobile.bean.Tariff;
import by.korolenko.mobile.repository.specification.Specification;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public class FindBetweenId implements Specification<Tariff> {

    /**
     * This is start id.
     */
    private int startId;
    /**
     * This is end id.
     */
    private int endId;

    /**
     * This is the constructor.
     *
     * @param newStartId start id
     * @param newEndId   end id
     */
    public FindBetweenId(final int newStartId, final int newEndId) {
        this.startId = newStartId;
        this.endId = newEndId;
    }

    /**
     * This method searches for matches between two id.
     *
     * @param list list to be searched.
     * @return result list
     */
    @Override
    public List<Tariff> specified(final List<Tariff> list) {
        return list.stream().filter(t -> t.getId() >= startId).
                filter(t -> t.getId() <= endId).collect(Collectors.toList());
    }
}
