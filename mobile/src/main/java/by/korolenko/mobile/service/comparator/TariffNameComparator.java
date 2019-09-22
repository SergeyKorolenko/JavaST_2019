package by.korolenko.mobile.service.comparator;

import by.korolenko.mobile.bean.Tariff;

import java.util.Comparator;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public class TariffNameComparator implements Comparator<Tariff> {
    /**
     * This method compares two tariffs by name.
     *
     * @param o1 compare object
     * @param o2 compare object
     * @return comparison result
     */
    @Override
    public int compare(final Tariff o1, final Tariff o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
