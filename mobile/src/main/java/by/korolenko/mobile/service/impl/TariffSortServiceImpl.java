package by.korolenko.mobile.service.impl;

import by.korolenko.mobile.bean.Tariff;
import by.korolenko.mobile.repository.Repository;
import by.korolenko.mobile.repository.impl.TariffRepository;
import by.korolenko.mobile.repository.specification.sort.SortByOneParam;
import by.korolenko.mobile.repository.specification.sort.SortByTwoParam;
import by.korolenko.mobile.service.TariffSortService;
import by.korolenko.mobile.service.comparator.TariffIdComparator;
import by.korolenko.mobile.service.comparator.TariffNameComparator;

import java.util.List;

public class TariffSortServiceImpl implements TariffSortService {

    /**
     * Repository.
     */
    private final Repository<Tariff> repository = new TariffRepository();

    /**
     * Sort by id.
     *
     * @return list of tariffs.
     */
    @Override
    public List<Tariff> sortById() {
        return repository.query(new SortByOneParam(new TariffIdComparator()));
    }

    /**
     * Sort by name.
     *
     * @return list of tariffs
     */
    @Override
    public List<Tariff> sortByName() {
        return repository.query(new SortByOneParam(new TariffNameComparator()));
    }

    /**
     * Sort by id and then by name.
     *
     * @return list of tariffs
     */
    @Override
    public List<Tariff> sortByIdAndName() {
        return repository.query(new SortByTwoParam(new TariffIdComparator(),
                new TariffNameComparator()));
    }
}
