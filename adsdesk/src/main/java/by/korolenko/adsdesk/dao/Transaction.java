package by.korolenko.adsdesk.dao;

import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.dao.exception.DaoException;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public interface Transaction {

    <T extends AbstractDao> T createDao(EntityType entityType);

    void commit() throws DaoException;

    void rollback() throws DaoException;
}
