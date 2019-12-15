package by.korolenko.adsdesk.service.impl;

import by.korolenko.adsdesk.bean.Locality;
import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.dao.LocalityDao;
import by.korolenko.adsdesk.dao.exception.DaoException;
import by.korolenko.adsdesk.service.AbstractService;
import by.korolenko.adsdesk.service.LocalityService;
import by.korolenko.adsdesk.service.exception.ServiceException;

import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public class LocalityServiceImpl extends AbstractService implements LocalityService {
    @Override
    public List<Locality> readAll() throws ServiceException {
        LocalityDao localityDao = transaction.createDao(EntityType.LOCALITY);
        try {
            return localityDao.readAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
