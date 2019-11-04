package by.korolenko.xml.service.builders;

import by.korolenko.xml.bean.GemType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 29.10.2019
 */
public abstract class AbstractGemsBuilder {

    /**
     * List of gems.
     */
    protected List<GemType> gems;

    /**
     * Constructor.
     */
    public AbstractGemsBuilder() {
        gems = new ArrayList<>();
    }

    /**
     * Getter for list of gems.
     *
     * @return list of gems
     */
    public List<GemType> getGems() {
        return gems;
    }

    /**
     * Building list of gems method.
     *
     * @param fileName file name
     */
    abstract public void buildListGems(String fileName);
}
