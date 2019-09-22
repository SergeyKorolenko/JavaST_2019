package by.korolenko.mobile.service.validator;

import by.korolenko.mobile.bean.enums.Messenger;
import by.korolenko.mobile.bean.enums.TariffType;

public class TariffValidator {

    /**
     * This method check tariff data.
     *
     * @param data tariff data
     * @return check result
     */
    public boolean isTariff(final String[] data) {
        final int tariffType = 0;
        final int name = 1;
        final int price = 2;
        final int minute = 3;
        final int traffic = 4;
        boolean result;
        try {
            TariffType type = TariffType.valueOf(data[tariffType]);
            if (isName(data[name]) && isDoubleNumber(data[price])
                    && isIntNumber(data[minute])
                    && isIntNumber(data[traffic])) {
                switch (type) {
                    case BUSINESS:
                    case HOME:
                        final int channelOrRoaming = 5;
                        if (isIntNumber(data[channelOrRoaming])) {
                            result = true;
                        } else {
                            result = false;
                        }
                        break;
                    case SOCIAL:
                        final int messenger = 5;
                        if (isMessengerType(data[messenger])) {
                            result = true;
                        } else {
                            result = false;
                        }
                        break;
                    default:
                        result = false;
                }
            } else {
                result = false;
            }
        } catch (IllegalArgumentException e) {
            result = false;
        }
        return result;
    }

    /**
     * This method checks name.
     *
     * @param name name
     * @return result
     */
    public boolean isName(final String name) {
        StringValidator stringValidator = new StringValidator();
        return stringValidator.isRightString(name);
    }

    /**
     * This method checks id.
     *
     * @param number id
     * @return result
     */
    public boolean isIntNumber(final String number) {
        NumberValidator numberValidator = new NumberValidator();
        return numberValidator.isInt(number);
    }

    /**
     * This method checks id.
     *
     * @param number id
     * @return result
     */
    public boolean isDoubleNumber(final String number) {
        NumberValidator numberValidator = new NumberValidator();
        return numberValidator.isDouble(number);
    }

    /**
     * Thismethod checks tariff type.
     *
     * @param type tariff type
     * @return result
     */
    public boolean isMessengerType(final String type) {
        try {
            Messenger messenger = Messenger.valueOf(type);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
