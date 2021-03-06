package by.korolenko.adsdesk.service.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public class UserDataValidator {

    private static final String FIO_REGEX = "[A-Za-zА-Яа-яЁё]+[-]*[A-Za-zА-Яа-яЁё]+";

    private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";

    private static final String PASS_REGEX = "(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,15}";

    private static final String LOGIN_REGEX = "^[\\w]{3,32}$";

    private static final long MIN_NUMBER = 375_25_100_00_00L;

    private static final long MAX_NUMBER = 375_33_999_99_99L;

    public boolean isFIO(String name) {
        Pattern pattern = Pattern.compile(FIO_REGEX);
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }

    public boolean isLogin(String login) {
        Pattern pattern = Pattern.compile(LOGIN_REGEX);
        Matcher matcher = pattern.matcher(login);
        return matcher.find();
    }

    public boolean isPassword(String password) {
        Pattern pattern = Pattern.compile(PASS_REGEX);
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    public boolean isPhoneNumber(long phone) {
        return phone >= MIN_NUMBER && phone <= MAX_NUMBER;
    }

    public boolean isEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
}
