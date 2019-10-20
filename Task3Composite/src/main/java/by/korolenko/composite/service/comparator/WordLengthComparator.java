package by.korolenko.composite.service.comparator;

import by.korolenko.composite.bean.Component;
import by.korolenko.composite.bean.Composite;

import java.util.Comparator;

public class WordLengthComparator implements Comparator<Component> {

    /**
     * Compare method.
     *
     * @param o1 object 1
     * @param o2 object 2
     * @return result
     */
    @Override
    public int compare(final Component o1, final Component o2) {
        return ((Composite) o1).size() - ((Composite) o2).size();
    }
}
