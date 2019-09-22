package by.korolenko.mobile.service.factory;

import by.korolenko.mobile.service.TariffCommonService;
import by.korolenko.mobile.service.TariffFileService;
import by.korolenko.mobile.service.TariffFindService;
import by.korolenko.mobile.service.TariffSortService;
import by.korolenko.mobile.service.impl.TariffCommonServiceImpl;
import by.korolenko.mobile.service.impl.TariffFileServiceImpl;
import by.korolenko.mobile.service.impl.TariffFindServiceImpl;
import by.korolenko.mobile.service.impl.TariffSortServiceImpl;

public final class ServiceFactory {

    /**
     * This is service factory instance.
     */
    private static final ServiceFactory INSTANCE = new ServiceFactory();

    /**
     * Common tariff service.
     */
    private final TariffCommonService tariffCommonService =
            new TariffCommonServiceImpl();
    /**
     * Find tariff service.
     */
    private final TariffFindService tariffFindService =
            new TariffFindServiceImpl();
    /**
     * Sort tariff service.
     */
    private final TariffSortService tariffSortService =
            new TariffSortServiceImpl();

    /**
     * File tariff service.
     */
    private final TariffFileService tariffFileService =
            new TariffFileServiceImpl();

    /**
     * Constructor.
     */
    private ServiceFactory() {
    }

    /**
     * Getter for service factory instance.
     *
     * @return service factory instance
     */
    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    /**
     * Getter for common tariff service.
     *
     * @return common tariff service
     */
    public TariffCommonService getTariffCommonService() {
        return tariffCommonService;
    }

    /**
     * Getter for sort tariff service.
     *
     * @return sort tariff service
     */
    public TariffSortService getTariffSortService() {
        return tariffSortService;
    }

    /**
     * Getter for find tariff service.
     *
     * @return find tariff service
     */
    public TariffFindService getTariffFindService() {
        return tariffFindService;
    }

    /**
     * Getter for file tariff service.
     *
     * @return file tariff service
     */
    public TariffFileService getTariffFileService() {
        return tariffFileService;
    }
}
