package by.korolenko.composite.bean;

public class Lexeme implements Component {

    /**
     * Lexeme.
     */
    private String lexeme;

    /**
     * Constructor.
     *
     * @param newLexeme lexeme
     */
    public Lexeme(final String newLexeme) {
        this.lexeme = newLexeme;
    }

    /**
     * This method collects string.
     *
     * @return string
     */
    public String collect() {
        return lexeme;
    }
}
