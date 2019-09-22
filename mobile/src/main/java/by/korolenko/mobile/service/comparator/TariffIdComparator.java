package by.korolenko.mobile.service.comparator;

import by.korolenko.mobile.bean.Tariff;

import java.util.Comparator;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public final class TariffIdComparator implements Comparator<Tariff> {
    /**
     * This method compares two tariffs by id.
     *
     * @param o1 first tariff
     * @param o2 second tariff
     * @return comparison result
     */
    @Override
    public int compare(final Tariff o1, final Tariff o2) {
        if (o1.getId() > o2.getId()) {
            return 1;
        }
        return o1.getId() < o2.getId() ? -1 : 0;
    }
}
