package by.korolenko.composite.bean;

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
