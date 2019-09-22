package by.korolenko.mobile.service.impl;

import by.korolenko.mobile.bean.Tariff;
import by.korolenko.mobile.repository.Repository;
import by.korolenko.mobile.repository.impl.TariffRepository;
import by.korolenko.mobile.repository.specification.find.GetAll;
import by.korolenko.mobile.service.TariffCommonService;
import by.korolenko.mobile.service.factory.TariffFactory;
import by.korolenko.mobile.service.parser.StringParser;
import by.korolenko.mobile.service.validator.ParamValidator;
import by.korolenko.mobile.service.validator.TariffValidator;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public class TariffCommonServiceImpl implements TariffCommonService {

    /**
     * Repository.
     */
    private final Repository<Tariff> repository = new TariffRepository();

    /**
     * Tariff factory.
     */
    private final TariffFactory tariffFactory = TariffFactory.getInstance();

    /**
     * Add method.
     *
     * @param data data
     * @return number of added
     */
    @Override
    public int addTariff(final String data) {
        StringParser parser = new StringParser();
        String[] tariffData = parser.parseToString(data);
        ParamValidator paramValidator = new ParamValidator();
        TariffValidator tariffValidator = new TariffValidator();
        int result = 0;
        if (paramValidator.isSixParam(tariffData)
                && tariffValidator.isTariff(tariffData)) {
            Tariff tariff = tariffFactory.create(tariffData);
            result = repository.add(tariff);
        }
        return result;
    }

    /**
     * Update method.
     *
     * @param data data
     * @return number of updated
     */
    @Override
    public int updateTariff(final String data) {
        StringParser parser = new StringParser();
        String[] tariffData = parser.parseToString(data);
        ParamValidator paramValidator = new ParamValidator();
        TariffValidator tariffValidator = new TariffValidator();
        int result = 0;
        if (paramValidator.isSevenParam(tariffData)) {
            final int id = 6;
            if (tariffValidator.isIntNumber(tariffData[id])) {
                final int newLength = 6;
                String[] newTariffData = Arrays.copyOf(tariffData, newLength);
                if (tariffValidator.isTariff(newTariffData)) {
                    Tariff tariff = tariffFactory.create(newTariffData);
                    tariff.setId(Integer.parseInt(tariffData[id]));
                    result = repository.update(tariff);
                }
            }
        }
        return result;
    }

    /**
     * Delete method.
     *
     * @param data data
     * @return number of deleted
     */
    @Override
    public int deleteTariff(final String data) {
        StringParser parser = new StringParser();
        String[] tariffData = parser.parseToString(data);
        ParamValidator paramValidator = new ParamValidator();
        TariffValidator tariffValidator = new TariffValidator();
        int result = 0;
        if (paramValidator.isSevenParam(tariffData)) {
            final int id = 6;
            if (tariffValidator.isIntNumber(tariffData[id])) {
                final int newLength = 6;
                String[] newTariffData = Arrays.copyOf(tariffData, newLength);
                if (tariffValidator.isTariff(newTariffData)) {
                    Tariff tariff = tariffFactory.create(newTariffData);
                    tariff.setId(Integer.parseInt(tariffData[id]));
                    result = repository.delete(tariff);
                }
            }
        }
        return result;
    }

    /**
     * Get tariffs.
     *
     * @return list of tariffs
     */
    @Override
    public List<Tariff> getAllTariff() {
        return repository.query(new GetAll());
    }
}
