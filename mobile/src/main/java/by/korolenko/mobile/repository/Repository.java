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
     */
    void add(T item);

    /**
     * Delete method.
     *
     * @param item item
     */
    void delete(T item);

    /**
     * Update method.
     *
     * @param item item
     */
    void update(T item);

    /**
     * Query method.
     *
     * @param specification specification
     * @return list
     */
    List<T> query(Specification<T> specification);
}
