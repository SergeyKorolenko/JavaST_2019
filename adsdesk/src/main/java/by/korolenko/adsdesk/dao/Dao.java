package by.korolenko.adsdesk.dao;

import by.korolenko.adsdesk.bean.Entity;

import java.sql.SQLException;
import java.util.List;

/**
 * @param <T> type of entity
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
 */
public interface Dao<T extends Entity> {
    /**
     * This method returns all entities from database.
     *
     * @return list of entities
     * @throws SQLException exception
     */
    List<T> findAll() throws SQLException;

    /**
     * This method returns an entity by id.
     *
     * @param id id
     * @return return
     * @throws SQLException exception
     */
    T findEntityById(Integer id) throws SQLException;

    /**
     * This method deletes an entity by id.
     *
     * @param id id
     * @throws SQLException exception
     */
    void delete(Integer id) throws SQLException;

    /**
     * This method adds an entity to database.
     *
     * @param entity entity
     * @throws SQLException exception
     */
    void create(T entity) throws SQLException;

    /**
     * This method updates an entity.
     *
     * @param entity entity
     * @throws SQLException exception
     */
    void update(T entity) throws SQLException;
}
