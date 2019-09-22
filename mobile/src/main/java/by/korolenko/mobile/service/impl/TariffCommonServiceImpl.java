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
     */
    @Override
    public void addTariff(final String data) {
        StringParser parser = new StringParser();
        String[] tariffData = parser.parseToString(data);
        ParamValidator paramValidator = new ParamValidator();
        TariffValidator tariffValidator = new TariffValidator();
        if (paramValidator.isSixParam(tariffData)
                && tariffValidator.isTariff(tariffData)) {
            Tariff tariff = tariffFactory.create(tariffData);
            repository.add(tariff);
        }
    }

    /**
     * Update method.
     *
     * @param data data
     */
    @Override
    public void updateTariff(final String data) {
        StringParser parser = new StringParser();
        String[] tariffData = parser.parseToString(data);
        ParamValidator paramValidator = new ParamValidator();
        TariffValidator tariffValidator = new TariffValidator();
        if (paramValidator.isSevenParam(tariffData)) {
            final int id = 6;
            if (tariffValidator.isIntNumber(tariffData[id])) {
                final int newLength = 6;
                String[] newTariffData = Arrays.copyOf(tariffData, newLength);
                Tariff tariff = tariffFactory.create(newTariffData);
                tariff.setId(Integer.parseInt(tariffData[id]));
                repository.update(tariff);
            }
        }
    }

    /**
     * Delete method.
     *
     * @param data data
     */
    @Override
    public void deleteTariff(final String data) {
        StringParser parser = new StringParser();
        String[] tariffData = parser.parseToString(data);
        ParamValidator paramValidator = new ParamValidator();
        TariffValidator tariffValidator = new TariffValidator();
        if (paramValidator.isSevenParam(tariffData)) {
            final int id = 6;
            if (tariffValidator.isIntNumber(tariffData[id])) {
                final int newLength = 6;
                String[] newTariffData = Arrays.copyOf(tariffData, newLength);
                Tariff tariff = tariffFactory.create(newTariffData);
                tariff.setId(Integer.parseInt(tariffData[id]));
                repository.delete(tariff);
            }
        }
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
