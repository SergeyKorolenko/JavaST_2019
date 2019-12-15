package by.korolenko.adsdesk.service.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public class AdsDataValidator {

    private static final String TEXT_REGEX = "[A-Za-zА-Яа-яЁё\".?,!0-9 ]{10,4000}";
    private static final String HEADING_REGEX = "[A-Za-zА-Яа-яЁё\".?,!0-9 ]{10,100}";

    public boolean isText(String text) {
        Pattern pattern = Pattern.compile(TEXT_REGEX);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public boolean isHeading(String heading) {
        Pattern pattern = Pattern.compile(HEADING_REGEX);
        Matcher matcher = pattern.matcher(heading);
        return matcher.find();
    }

    public boolean isPrice(double price) {
        return price >= 0.0;
    }
}
