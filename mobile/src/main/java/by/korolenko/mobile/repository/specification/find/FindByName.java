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
public class FindByName implements Specification<Tariff> {

    /**
     * This is the search name.
     */
    private String name;

    /**
     * This is the constructor with parameters.
     *
     * @param newName search name
     */
    public FindByName(final String newName) {
        this.name = newName;
    }

    /**
     * This method searches for matches by name.
     *
     * @param list list to be searched
     * @return result list
     */
    @Override
    public List<Tariff> specified(final List<Tariff> list) {
        return list.stream().filter(n -> n.getName().equals(name)).
                collect(Collectors.toList());
    }
}
