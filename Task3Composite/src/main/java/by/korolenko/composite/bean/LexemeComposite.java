package by.korolenko.composite.bean;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class LexemeComposite extends TextComposite {

    /**
     * Space.
     */
    private static final String LEXEME_DELIMITER = " ";
    /**
     * This method collects string.
     *
     * @return string
     */
    @Override
    public String collect() {
        return super.collect() + LEXEME_DELIMITER;
    }
}
