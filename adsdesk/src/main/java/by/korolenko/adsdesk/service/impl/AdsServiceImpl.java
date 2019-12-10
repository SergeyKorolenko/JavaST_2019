package by.korolenko.adsdesk.service.impl;

import by.korolenko.adsdesk.bean.Ads;
import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.dao.AdsDao;
import by.korolenko.adsdesk.dao.exception.DaoException;
import by.korolenko.adsdesk.service.AbstractService;
import by.korolenko.adsdesk.service.AdsService;
import by.korolenko.adsdesk.service.exception.ServiceException;

import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
 */
public class AdsServiceImpl extends AbstractService implements AdsService {
    @Override
    public void delete(Integer adsId) throws ServiceException {
        AdsDao adsDao = transaction.createDao(EntityType.ADS);
        try {
            adsDao.delete(adsId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Ads> readAll() throws ServiceException {
        AdsDao adsDao = transaction.createDao(EntityType.ADS);
        try {
            return adsDao.readAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Ads> findByCategory(Integer categoryId) throws ServiceException {
        AdsDao adsDao = transaction.createDao(EntityType.ADS);
        try {
            return adsDao.findByCategory(categoryId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Ads findById(Integer id) throws ServiceException {
        AdsDao adsDao = transaction.createDao(EntityType.ADS);
        try {
            return adsDao.findById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int countAdsNumber() throws ServiceException {
        AdsDao adsDao = transaction.createDao(EntityType.ADS);
        try {
            return adsDao.countAdsNumber();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Ads> findAdsByPage(int currentPage, int recordsPerPage) throws ServiceException {
        AdsDao adsDao = transaction.createDao(EntityType.ADS);
        try {
            return adsDao.findAdsByPage(currentPage, recordsPerPage);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Ads> findByUserId(Integer userId) throws ServiceException {
        AdsDao adsDao = transaction.createDao(EntityType.ADS);
        try {
            return adsDao.findByUserId(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Ads> findByIncludingString(String substring) throws ServiceException {
        AdsDao adsDao = transaction.createDao(EntityType.ADS);
        try {
            return adsDao.findByIncludingString(substring);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void create(Ads ads) throws ServiceException {
        AdsDao adsDao = transaction.createDao(EntityType.ADS);
        try {
            adsDao.create(ads);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
