package by.korolenko.mobile.repository.specification.find;

import by.korolenko.mobile.bean.Tariff;
import by.korolenko.mobile.repository.specification.Specification;

import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public class GetAll implements Specification<Tariff> {

    /**
     * This method returns all tariffs.
     *
     * @param list tariff list
     * @return tariff list
     */
    @Override
    public List<Tariff> specified(final List<Tariff> list) {
        return list;
    }
}
