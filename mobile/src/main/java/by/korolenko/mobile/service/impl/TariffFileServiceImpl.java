package by.korolenko.mobile.service.impl;

import by.korolenko.mobile.bean.Tariff;
import by.korolenko.mobile.repository.Repository;
import by.korolenko.mobile.repository.impl.TariffRepository;
import by.korolenko.mobile.service.TariffCommonService;
import by.korolenko.mobile.service.TariffFileService;
import by.korolenko.mobile.service.factory.ServiceFactory;
import by.korolenko.mobile.service.input.FileDataReader;
import by.korolenko.mobile.service.output.FileDataWriter;

import java.util.List;

public class TariffFileServiceImpl implements TariffFileService {

    /**
     * Repository.
     */
    private final Repository<Tariff> repository = new TariffRepository();
    /**
     * This is the file name.
     */
    public static final String INPUT_FILE = "data/input.txt";

    /**
     * Read from file.
     */
    @Override
    public void readFromFile() {
        FileDataReader fileDataReader = new FileDataReader();
        List<String> data = fileDataReader.readData(INPUT_FILE);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TariffCommonService tariffCommonService = serviceFactory.
                getTariffCommonService();
        for (String line : data) {
            tariffCommonService.addTariff(line);
        }
    }

    /**
     * Write to file.
     *
     * @param data data
     */
    @Override
    public void writeToFile(final List<String> data) {
        FileDataWriter fileDataWriter = new FileDataWriter();
    }
}
