package by.korolenko.mobile.service;

import by.korolenko.mobile.bean.Tariff;

import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public interface TariffCommonService {

    /**
     * Add method.
     *
     * @param data data
     * @return number of added
     */
    int addTariff(String data);

    /**
     * Update method.
     *
     * @param data data
     * @return number of updated
     */
    int updateTariff(String data);

    /**
     * Delete method.
     *
     * @param data data
     * @return number of deleted
     */
    int deleteTariff(String data);

    /**
     * Get tariffs.
     *
     * @return list of tariffs
     */
    List<Tariff> getAllTariff();
}
