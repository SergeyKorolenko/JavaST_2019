package by.korolenko.composite.bean;

public class Sentence implements Component {

    /**
     * Sentence.
     */
    private String sentence;

    /**
     * Constructor.
     *
     * @param newSentence sentence
     */
    public Sentence(final String newSentence) {
        this.sentence = newSentence;
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
