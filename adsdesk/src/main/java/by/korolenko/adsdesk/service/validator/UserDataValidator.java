package by.korolenko.adsdesk.service.validator;

public class UserDataValidator {

    private static final String FIO_REGEX = "[]";

    public boolean isFIO(String name) {
        return false;
    }

    public boolean isLogin(String login) {
        return false;
    }

    public boolean isPassword(String password) {
        return false;
    }

    public boolean isPhoneNumber(long phone) {
        return false;
    }

    public boolean isEmail(String email) {
        return false;
    }
}
