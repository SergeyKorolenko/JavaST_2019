package by.korolenko.mobile.service;

import by.korolenko.mobile.bean.Tariff;

import java.util.List;

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
