package by.korolenko.adsdesk.dao;

import by.korolenko.adsdesk.bean.Ads;
import by.korolenko.adsdesk.dao.exception.DaoException;

import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
 */
public interface AdsDao extends Dao<Ads> {

    List<Ads> readAll() throws DaoException;

    List<Ads> findByCategory(Integer categoryId) throws DaoException;

    int countAdsNumber() throws DaoException;

    List<Ads> findAdsByPage(int currentPage, int recordsPerPage) throws DaoException;
}
