package by.korolenko.mobile.repository;

import by.korolenko.mobile.repository.specification.Specification;

import java.util.List;

/**
 * @param <T> any class
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public interface Repository<T> {
    /**
     * Add method.
     *
     * @param item item
     * @return number of added
     */
    int add(T item);

    /**
     * Delete method.
     *
     * @param item item
     * @return number of deleted
     */
    int delete(T item);

    /**
     * Update method.
     *
     * @param item item
     * @return number of updated
     */
    int update(T item);

    /**
     * Query method.
     *
     * @param specification specification
     * @return list
     */
    List<T> query(Specification<T> specification);
}
