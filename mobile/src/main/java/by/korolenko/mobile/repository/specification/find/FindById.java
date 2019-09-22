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
public class FindById implements Specification<Tariff> {

    /**
     * Id to be searched.
     */
    private int id;

    /**
     * This is the constructor.
     *
     * @param newId id
     */
    public FindById(final int newId) {
        this.id = newId;
    }

    /**
     * This method searches for matches by id.
     *
     * @param list list to be searched
     * @return result list
     */
    @Override
    public List<Tariff> specified(final List<Tariff> list) {
        return list.stream().filter(t -> t.getId() == id).
                collect(Collectors.toList());
    }
}
