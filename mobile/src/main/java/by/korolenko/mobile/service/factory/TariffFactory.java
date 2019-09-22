package by.korolenko.mobile.service.factory;

import by.korolenko.mobile.bean.BusinessTariff;
import by.korolenko.mobile.bean.HomeTariff;
import by.korolenko.mobile.bean.SocialTariff;
import by.korolenko.mobile.bean.Tariff;
import by.korolenko.mobile.bean.enums.Messenger;
import by.korolenko.mobile.bean.enums.TariffType;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public class TariffFactory {
    /**
     * This is the tariff factory instance.
     */
    private static final TariffFactory INSTANCE = new TariffFactory();

    /**
     * This method creates any tariff.
     *
     * @param data data
     * @return tariff
     */
    public Tariff create(final String[] data) {
        Tariff tariff = null;
        String type = data[0];
        final int name = 1;
        final int price = 2;
        final int minute = 3;
        final int traffic = 4;
        TariffType tariffType = TariffType.valueOf(type.toUpperCase());
        switch (tariffType) {
            case SOCIAL:
                final int messenger = 5;
                tariff = new SocialTariff(data[name], Double.
                        parseDouble(data[price]), Integer.
                        parseInt(data[minute]), Integer.
                        parseInt(data[traffic]), Messenger.
                        valueOf(data[messenger].toUpperCase()));
                break;
            case HOME:
                final int channel = 5;
                tariff = new HomeTariff(data[name], Double.
                        parseDouble(data[price]), Integer.
                        parseInt(data[minute]), Integer.
                        parseInt(data[traffic]), Integer.
                        parseInt(data[channel]));
                break;
            case BUSINESS:
                final int roaming = 5;
                tariff = new BusinessTariff(data[name], Double.
                        parseDouble(data[price]), Integer.
                        parseInt(data[minute]), Integer.
                        parseInt(data[traffic]), Integer.
                        parseInt(data[roaming]));
                break;
            default:
        }
        return tariff;
    }

    /**
     * Getter for instance.
     *
     * @return tariff factory instance
     */
    public static TariffFactory getInstance() {
        return INSTANCE;
    }
}
