package by.korolenko.adsdesk.dao;

import by.korolenko.adsdesk.bean.Image;
import by.korolenko.adsdesk.dao.exception.DaoException;

import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public interface ImageDao extends Dao<Image> {

    List<Image> findByAdsId(Integer adsId) throws DaoException;
}
