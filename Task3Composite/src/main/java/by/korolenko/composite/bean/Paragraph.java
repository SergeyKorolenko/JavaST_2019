package by.korolenko.composite.bean;

public class Paragraph implements Component {

    /**
     * Paragraph.
     */
    private String paragraph;

    /**
     * Constructor.
     *
     * @param newParagraph paragraph
     */
    public Paragraph(final String newParagraph) {
        this.paragraph = newParagraph;
    }

    /**
     * This method collects string.
     *
     * @return string
     */
    public String collect() {
        return "";
    }
}
