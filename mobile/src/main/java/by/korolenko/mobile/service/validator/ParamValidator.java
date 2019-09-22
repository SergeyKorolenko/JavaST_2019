package by.korolenko.mobile.service.validator;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public class ParamValidator {

    /**
     * This method checks number of parameters.
     *
     * @param param param
     * @return check result
     */
    public boolean isSevenParam(final String[] param) {
        final int length = 6;
        return length == param.length;
    }

    /**
     * This method checks number of parameters.
     *
     * @param param param
     * @return check result
     */
    public boolean isSixParam(final String[] param) {
        final int length = 6;
        return length == param.length;
    }

    /**
     * This method checks number of parameters.
     *
     * @param param param
     * @return check result
     */
    public boolean isTwoParam(final String[] param) {
        final int length = 2;
        return length == param.length;
    }

    /**
     * This method checks number of parameters.
     *
     * @param param param
     * @return check result
     */
    public boolean isThreeParam(final String[] param) {
        final int length = 3;
        return length == param.length;
    }
}
