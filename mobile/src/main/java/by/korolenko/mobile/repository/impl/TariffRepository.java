package by.korolenko.mobile.repository.impl;

import by.korolenko.mobile.bean.Storage;
import by.korolenko.mobile.bean.Tariff;
import by.korolenko.mobile.repository.Repository;
import by.korolenko.mobile.repository.specification.Specification;

import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public class TariffRepository implements Repository<Tariff> {
    /**
     * This is the store instance.
     */
    private Storage storage = Storage.getInstance();

    /**
     * Add any tariff.
     *
     * @param item tariff
     */
    @Override
    public void add(final Tariff item) {
        storage.getTariffList().add(item);
    }

    /**
     * Any tariff.
     *
     * @param item tariff
     */
    @Override
    public void delete(final Tariff item) {
        storage.getTariffList().remove(item);
    }

    /**
     * Any tariff.
     *
     * @param item tariff
     */
    @Override
    public void update(final Tariff item) {
    }

    /**
     * This is the query method.
     *
     * @param specification specification
     * @return list of tariffs
     */
    @Override
    public List<Tariff> query(final Specification<Tariff> specification) {
        return specification.specified(storage.getTariffList());
    }


}
