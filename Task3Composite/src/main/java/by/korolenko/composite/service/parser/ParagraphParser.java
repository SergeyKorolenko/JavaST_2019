package by.korolenko.composite.service.parser;

import by.korolenko.composite.bean.StringLeaf;
import by.korolenko.composite.bean.TextComposite;
import by.korolenko.composite.bean.ParagraphComposite;

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
    public TextComposite parse(final TextComposite composite,
                               final String text) {
        String[] list = text.trim().split(PARAGRAPH_REGEX);
        for (String line : list) {
            TextComposite paragraph = new ParagraphComposite();
            if (getNextParser() == null) {
                paragraph.add(new StringLeaf(line));
            } else {
                paragraph = getNextParser().parse(paragraph, line);
            }
            composite.add(paragraph);
        }
        return composite;
    }
}
