package by.korolenko.xml.repository.impl;

import by.korolenko.xml.bean.GemStorage;
import by.korolenko.xml.bean.GemType;
import by.korolenko.xml.repository.Repository;

import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 29.10.2019
 */
public class GemRepository implements Repository {

    /**
     * Gem storage.
     */
    private GemStorage storage = GemStorage.getInstance();

    /**
     * Adding method.
     *
     * @param gemTypeList list of gems
     */
    @Override
    public void addGems(final List<GemType> gemTypeList) {
        storage.setGemTypeList(gemTypeList);
    }

    /**
     * Getting method.
     *
     * @return
     */
    @Override
    public List<GemType> getGems() {
        return storage.getGemTypeList();
    }
}
