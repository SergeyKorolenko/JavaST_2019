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

    void delete(Integer adsId) throws DaoException;

    List<Ads> readAll() throws DaoException;

    List<Ads> findByCategory(Integer categoryId) throws DaoException;

    int countAdsNumber() throws DaoException;

    List<Ads> findAdsByPage(int currentPage, int recordsPerPage) throws DaoException;

    List<Ads> findByUserId(Integer userId) throws DaoException;

    List<Ads> findByIncludingString(String substring) throws DaoException;

    List<Ads> findBySubcategory(Integer subcategoryId) throws DaoException;

    List<Ads> sortByDate() throws DaoException;

    List<Ads> sortByDecreasePrice() throws DaoException;

    List<Ads> sortByIncreasePrice() throws DaoException;

    void activate(Integer adsId) throws DaoException;

    void deactivate(Integer adsId) throws DaoException;
}
