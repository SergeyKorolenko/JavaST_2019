package by.korolenko.adsdesk.service;

import by.korolenko.adsdesk.bean.Ads;
import by.korolenko.adsdesk.service.exception.ServiceException;

import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
 */
public interface AdsService {

    void delete(Integer adsId) throws ServiceException;

    List<Ads> readAll() throws ServiceException;

    List<Ads> findByCategory(Integer categoryId) throws ServiceException;

    Ads findById(Integer id) throws ServiceException;

    int countAdsNumber() throws ServiceException;

    List<Ads> findAdsByPage(int currentPage, int recordsPerPage) throws ServiceException;

    List<Ads> findByUserId(Integer userId) throws ServiceException;

    List<Ads> findByIncludingString(String substring) throws ServiceException;

    void create(Ads ads) throws ServiceException;
}
