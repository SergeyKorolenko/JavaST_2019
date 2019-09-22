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
     */
    void addTariff(String data);

    /**
     * Update method.
     *
     * @param data data
     */
    void updateTariff(String data);

    /**
     * Delete method.
     *
     * @param data data
     */
    void deleteTariff(String data);

    /**
     * Get tariffs.
     *
     * @return list of tariffs
     */
    List<Tariff> getAllTariff();
}
