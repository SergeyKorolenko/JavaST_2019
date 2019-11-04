package by.korolenko.xml.repository;

import by.korolenko.xml.bean.GemType;

import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 29.10.2019
 */
public interface Repository {

    /**
     * Adding method.
     *
     * @param gemTypeList list of gems
     */
    void addGems(List<GemType> gemTypeList);

    /**
     * Getting method.
     *
     * @return list of gems
     */
    List<GemType> getGems();
}
