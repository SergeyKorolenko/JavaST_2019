package by.korolenko.adsdesk.dao;

import by.korolenko.adsdesk.bean.Locality;
import by.korolenko.adsdesk.dao.exception.DaoException;

import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public interface LocalityDao extends Dao<Locality> {

    List<Locality> readAll() throws DaoException;
}
