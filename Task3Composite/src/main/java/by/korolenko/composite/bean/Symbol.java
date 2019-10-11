package by.korolenko.composite.bean;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class Symbol implements Component {
    /**
     * Symbol.
     */
    private char symbol;

    /**
     * Constructor.
     *
     * @param newSymbol symbol
     */
    public Symbol(final char newSymbol) {
        this.symbol = newSymbol;
    }

    /**
     * This method collects string.
     *
     * @return string
     */
    public String collect() {
        return Character.toString(symbol);
    }
}
