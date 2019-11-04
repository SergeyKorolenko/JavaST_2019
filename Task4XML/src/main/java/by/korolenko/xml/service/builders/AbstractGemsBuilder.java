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
     * Set of gems.
     */
    protected List<GemType> gems;

    /**
     * Constructor.
     */
    public AbstractGemsBuilder() {
        gems = new ArrayList<>();
    }

    /**
     * Getter for set of gems.
     *
     * @return set of gems
     */
    public List<GemType> getGems() {
        return gems;
    }

    /**
     * Building set of gems method.
     *
     * @param fileName file name
     */
    abstract public void buildSetGems(String fileName);
}
