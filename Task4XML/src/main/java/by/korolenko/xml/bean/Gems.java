package by.korolenko.xml.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 29.10.2019
 */
public class Gems {

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
     * Adding method.
     *
     * @param gemType gem type
     * @return result
     */
    public boolean add(final GemType gemType) {
        return gemTypeList.add(gemType);
    }


    /**
     * To string.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "Gems{"
                + "gemTypeList=" + gemTypeList
                + '}';
    }
}
