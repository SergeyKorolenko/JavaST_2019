package by.korolenko.mobile.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public final class Storage {

    /**
     * This is the store instance.
     */
    private static final Storage INSTANCE = new Storage();

    /**
     * List of tariffs.
     */
    private List<Tariff> tariffList = new ArrayList<>();

    /**
     * Private constructor.
     */
    private Storage() {
    }

    /**
     * Getter for instance.
     *
     * @return store instance
     */
    public static Storage getInstance() {
        return INSTANCE;
    }

    /**
     * Getter fo list.
     *
     * @return list of tariffs
     */
    public List<Tariff> getTariffList() {
        return tariffList;
    }
}
