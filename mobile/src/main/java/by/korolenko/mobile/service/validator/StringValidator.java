package by.korolenko.mobile.service.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public class StringValidator {

    /**
     * RegEx for string.
     */
    private final String regEx = "[a-zA-Z0-9-]+";

    /**
     * This method checks string data.
     *
     * @param data data
     * @return check result
     */
    public boolean isRightString(final String data) {
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }
}
