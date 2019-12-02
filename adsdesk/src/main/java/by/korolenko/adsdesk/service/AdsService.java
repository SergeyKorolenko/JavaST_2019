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

    List<Ads> readAll() throws ServiceException;

    List<Ads> findByCategory(Integer categoryId) throws ServiceException;

    Ads findById(Integer id) throws ServiceException;
}
