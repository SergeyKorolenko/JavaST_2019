package by.korolenko.adsdesk.dao;

import by.korolenko.adsdesk.bean.Entity;
import by.korolenko.adsdesk.dao.exception.DaoException;

/**
 * @param <T> type of entity
 * @author Sergei Korolenko
 * @version 1.0
 */
public interface Dao<T extends Entity> {

    /**
     * This method returns an entity by id.
     *
     * @param id id
     * @return entity
     * @throws DaoException exception
     */
    default T findById(Integer id) throws DaoException {
        throw new UnsupportedOperationException();
    }

    /**
     * This method deletes an entity by id.
     *
     * @param id id
     * @throws DaoException exception
     */
    default void delete(Integer id) throws DaoException {
        throw new UnsupportedOperationException();
    }

    /**
     * This method adds an entity to the database.
     *
     * @param entity entity
     * @throws DaoException exception
     */
    default void create(T entity) throws DaoException {
        throw new UnsupportedOperationException();
    }

    /**
     * This method updates an entity.
     *
     * @param entity entity
     * @throws DaoException exception
     */
    default void update(T entity) throws DaoException {
        throw new UnsupportedOperationException();
    }
}
