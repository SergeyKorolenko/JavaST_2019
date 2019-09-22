package by.korolenko.mobile.repository.specification;

import java.util.List;

/**
 * @param <T> any class
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public interface Specification<T> {
    /**
     * This is specified method.
     *
     * @param list list
     * @return list
     */
    List<T> specified(List<T> list);
}
