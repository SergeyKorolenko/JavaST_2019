package by.korolenko.composite.service.parser;

import by.korolenko.composite.bean.Composite;
import by.korolenko.composite.bean.enums.TextPart;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class ParagraphParser extends Parser {

    /**
     * Paragraph regex.
     */
    private static final String PARAGRAPH_REGEX = " {4}";

    /**
     * Parse method.
     *
     * @param composite composite
     * @param text      line
     * @return composite
     */
    @Override
    public Composite parse(final Composite composite,
                           final String text) {
        String[] list = text.trim().split(PARAGRAPH_REGEX);
        for (String line : list) {
            Composite paragraph = new Composite(TextPart.PARAGRAPH);
            paragraph = getNextParser().parse(paragraph, line);
            composite.add(paragraph);
        }
        return composite;
    }
}
