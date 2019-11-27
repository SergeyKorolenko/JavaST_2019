package by.korolenko.adsdesk.dao;

import by.korolenko.adsdesk.bean.Entity;
import by.korolenko.adsdesk.dao.exception.DaoException;

/**
 * @param <T> type of entity
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
 */
public interface Dao<T extends Entity> {

    /**
     * This method returns an entity by id.
     *
     * @param id id
     * @return entity
     * @throws DaoException exception
     */
    T findById(Integer id) throws DaoException;

    /**
     * This method deletes an entity by id.
     *
     * @param id id
     * @throws DaoException exception
     */
    void delete(Integer id) throws DaoException;

    /**
     * This method adds an entity to the database.
     *
     * @param entity entity
     * @throws DaoException exception
     */
    void create(T entity) throws DaoException;

    /**
     * This method updates an entity.
     *
     * @param entity entity
     * @throws DaoException exception
     */
    void update(T entity) throws DaoException;
}
