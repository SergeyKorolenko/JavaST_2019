package by.korolenko.composite.service.comparator;

import java.util.Comparator;

public class StringComparator implements Comparator<String> {
    /**
     * Compare method.
     *
     * @param o1 string 1
     * @param o2 string 2
     * @return result
     */
    @Override
    public int compare(final String o1, final String o2) {
        return o1.compareTo(o2);
    }
}
