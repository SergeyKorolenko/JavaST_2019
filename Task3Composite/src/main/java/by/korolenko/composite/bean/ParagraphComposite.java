package by.korolenko.composite.bean;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class ParagraphComposite extends TextComposite {

    /**
     * Paragraph.
     */
    private static final String PARAGRAPH_DELIMITER = "    ";
    /**
     * This method collects string.
     *
     * @return string
     */
    @Override
    public String collect() {
        return PARAGRAPH_DELIMITER + super.collect().trim();
    }
}
