package by.korolenko.mobile.service.comparator;

import by.korolenko.mobile.bean.Tariff;

import java.util.Comparator;

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
