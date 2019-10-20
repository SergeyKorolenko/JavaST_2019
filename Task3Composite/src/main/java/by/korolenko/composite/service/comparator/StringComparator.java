package by.korolenko.composite.service.comparator;

import java.util.Comparator;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class StringComparator implements Comparator<String> {
    /**
     * Compared method.
     *
     * @param o1 first string
     * @param o2 second string
     * @return result
     */
    @Override
    public int compare(final String o1, final String o2) {
        return o1.compareTo(o2);
    }
}
