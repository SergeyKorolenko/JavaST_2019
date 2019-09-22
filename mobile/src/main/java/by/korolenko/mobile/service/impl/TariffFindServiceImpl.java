package by.korolenko.mobile.service.impl;

import by.korolenko.mobile.bean.Tariff;
import by.korolenko.mobile.repository.Repository;
import by.korolenko.mobile.repository.impl.TariffRepository;
import by.korolenko.mobile.repository.specification.find.FindBetweenId;
import by.korolenko.mobile.repository.specification.find.FindById;
import by.korolenko.mobile.repository.specification.find.FindByName;
import by.korolenko.mobile.service.TariffFindService;
import by.korolenko.mobile.service.parser.StringParser;
import by.korolenko.mobile.service.validator.ParamValidator;
import by.korolenko.mobile.service.validator.NumberValidator;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public class TariffFindServiceImpl implements TariffFindService {

    /**
     * Repository.
     */
    private final Repository<Tariff> repository = new TariffRepository();

    /**
     * Find by id.
     *
     * @param data data
     * @return list of tariffs
     */
    @Override
    public List<Tariff> findById(final String data) {
        StringParser parser = new StringParser();
        String[] result = parser.parseToString(data);
        ParamValidator validator = new ParamValidator();
        NumberValidator numberValidator = new NumberValidator();
        final int idIndex = 0;
        if (validator.isOneParam(result) && numberValidator.
                isInt(result[idIndex])) {
            int id = Integer.parseInt(result[idIndex]);
            return repository.query(new FindById(id));
        }
        return new ArrayList<>();
    }

    /**
     * Find by name.
     *
     * @param data data
     * @return list of tariffs
     */
    @Override
    public List<Tariff> findByName(final String data) {
        StringParser parser = new StringParser();
        String[] result = parser.parseToString(data);
        ParamValidator validator = new ParamValidator();
        final int nameIndex = 0;
        if (validator.isOneParam(result)) {
            String name = result[nameIndex];
            return repository.query(new FindByName(name));
        }
        return new ArrayList<>();
    }

    /**
     * Find between id.
     *
     * @param data data
     * @return list of tariffs
     */
    @Override
    public List<Tariff> findBetweenId(final String data) {
        StringParser parser = new StringParser();
        String[] result = parser.parseToString(data);
        ParamValidator validator = new ParamValidator();
        NumberValidator numberValidator = new NumberValidator();
        final int startIdIndex = 0;
        final int endIdIndex = 1;
        if (validator.isTwoParam(result) && numberValidator.
                isInt(result[startIdIndex]) && numberValidator.
                isInt(result[endIdIndex])) {
            int startId = Integer.parseInt(result[startIdIndex]);
            int endId = Integer.parseInt(result[endIdIndex]);
            return repository.query(new FindBetweenId(startId, endId));
        }
        return new ArrayList<>();
    }
}
