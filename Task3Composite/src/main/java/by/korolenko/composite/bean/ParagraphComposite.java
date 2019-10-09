package by.korolenko.composite.bean;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class ParagraphComposite extends TextComposite {

    /**
     * This method collects string.
     *
     * @return string
     */
    public String collect() {
        return "    " + super.collect().trim();
    }
}
