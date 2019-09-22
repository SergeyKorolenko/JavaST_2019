package by.korolenko.mobile.service;

import by.korolenko.mobile.bean.Tariff;

import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public interface TariffSortService {

    /**
     * Sort by id.
     *
     * @return list of tariffs
     */
    List<Tariff> sortById();

    /**
     * Sort by name.
     *
     * @return list of tariffs
     */
    List<Tariff> sortByName();

    /**
     * Sort by id and then by name.
     *
     * @return list of tariffs.
     */
    List<Tariff> sortByIdAndName();
}
