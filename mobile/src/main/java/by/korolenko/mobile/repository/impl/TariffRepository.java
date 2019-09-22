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
     * @return number of added
     */
    @Override
    public int add(final Tariff item) {
        int beforeSize = storage.getTariffList().size();
        storage.getTariffList().add(item);
        return storage.getTariffList().size() - beforeSize;
    }

    /**
     * Any tariff.
     *
     * @param item tariff
     * @return number of deleted
     */
    @Override
    public int delete(final Tariff item) {
        int beforeSize = storage.getTariffList().size();
        storage.getTariffList().remove(item);
        return beforeSize - storage.getTariffList().size();
    }

    /**
     * Any tariff.
     *
     * @param item tariff
     * @return number of updated
     */
    @Override
    public int update(final Tariff item) {
        List<Tariff> list = storage.getTariffList();
        int updated = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == item.getId()) {
                storage.getTariffList().set(i, item);
                updated++;
            }
        }
        return updated;
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
