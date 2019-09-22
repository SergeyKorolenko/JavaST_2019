package by.korolenko.mobile.service.impl;

import by.korolenko.mobile.bean.Tariff;
import by.korolenko.mobile.repository.Repository;
import by.korolenko.mobile.repository.impl.TariffRepository;
import by.korolenko.mobile.service.TariffCommonService;
import by.korolenko.mobile.service.TariffFileService;
import by.korolenko.mobile.service.factory.ServiceFactory;
import by.korolenko.mobile.service.input.FileDataReader;
import by.korolenko.mobile.service.output.FileDataWriter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public class TariffFileServiceImpl implements TariffFileService {

    /**
     * Repository.
     */
    private final Repository<Tariff> repository = new TariffRepository();
    /**
     * This is the input file.
     */
    private static final String INPUT_FILE = "data/input.txt";
    /**
     * This is the input file.
     */
    private static final String OUTPUT_FILE = "data/output.txt";

    /**
     * Read from file.
     * @return number of read
     */
    @Override
    public int readFromFile() {
        FileDataReader fileDataReader = new FileDataReader();
        List<String> data = fileDataReader.readData(INPUT_FILE);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TariffCommonService tariffCommonService = serviceFactory.
                getTariffCommonService();
        int result = 0;
        for (String line : data) {
            result += tariffCommonService.addTariff(line);
        }
        return result;
    }

    /**
     * Write to file.
     *
     * @return number of written
     */
    @Override
    public int writeToFile() {
        FileDataWriter fileDataWriter = new FileDataWriter();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TariffCommonService tariffCommonService = serviceFactory.
                getTariffCommonService();
        List<Tariff> tariffList = tariffCommonService.getAllTariff();
        List<String> data = new ArrayList<>();
        for (Tariff tariff : tariffList) {
            data.add(tariff.toString());
        }
        return fileDataWriter.writeData(data, OUTPUT_FILE);
    }
}
