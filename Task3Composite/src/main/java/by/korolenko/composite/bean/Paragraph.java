package by.korolenko.composite.bean;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class Paragraph extends Composite {

    /**
     * Paragraph.
     */
    private static final String PARAGRAPH_DELIMITER = "    ";
    /**
     * Enter.
     */
    private static final String ENTER = "\n";

    /**
     * This method collects string.
     *
     * @return string
     */
    @Override
    public String collect() {
        return PARAGRAPH_DELIMITER + super.collect().trim() + ENTER;
    }
}
