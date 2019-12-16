package by.korolenko.adsdesk.service.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public class CommentDataValidator {

    private static final String TEXT_REGEX = "[A-Za-zА-Яа-яЁё\".?,:;!0-9 -]{1,2000}";

    public boolean isText(String text) {
        Pattern pattern = Pattern.compile(TEXT_REGEX);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }
}
