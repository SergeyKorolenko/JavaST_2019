package by.korolenko.composite.service.comparator;

import by.korolenko.composite.bean.Component;
import by.korolenko.composite.bean.Composite;

import java.util.Comparator;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class CompositeSizeComparator implements Comparator<Component> {

    /**
     * Compared method.
     *
     * @param o1 first component
     * @param o2 second component
     * @return result
     */
    @Override
    public int compare(final Component o1, final Component o2) {
        return ((Composite) o1).size() - ((Composite) o2).size();
    }
}
