package by.korolenko.mobile.service;

import by.korolenko.mobile.bean.Tariff;

import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public interface TariffFindService {
    /**
     * Find by id.
     *
     * @param data data
     * @return list of tariffs
     */
    List<Tariff> findById(String data);

    /**
     * Find by name.
     *
     * @param data data
     * @return list of tariffs
     */
    List<Tariff> findByName(String data);

    /**
     * Find between id.
     *
     * @param data data
     * @return list of tariffs
     */
    List<Tariff> findBetweenId(String data);
}
