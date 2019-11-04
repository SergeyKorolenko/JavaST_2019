package by.korolenko.xml.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 29.10.2019
 */
public final class GemStorage {

    /**
     * Gem storage.
     */
    private static final GemStorage INSTANCE = new GemStorage();

    private GemStorage() {
    }

    /**
     * List of gems.
     */
    private List<GemType> gemTypeList = new ArrayList<>();

    /**
     * Setter for list of gems.
     *
     * @param newGemTypeList list of gems
     */
    public void setGemTypeList(final List<GemType> newGemTypeList) {
        this.gemTypeList = newGemTypeList;
    }

    /**
     * Getter for list of gems.
     *
     * @return list of gems.
     */
    public List<GemType> getGemTypeList() {
        return new ArrayList<>(gemTypeList);
    }

    /**
     * Getter for gem storage.
     *
     * @return instance
     */
    public static GemStorage getInstance() {
        return GemStorage.INSTANCE;
    }
}
