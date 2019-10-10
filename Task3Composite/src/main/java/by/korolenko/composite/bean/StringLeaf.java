package by.korolenko.composite.bean;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class StringLeaf implements Component {
    /**
     * Symbol.
     */
    private String symbol;

    /**
     * Constructor.
     *
     * @param newSymbol symbol
     */
    public StringLeaf(final String newSymbol) {
        this.symbol = newSymbol;
    }

    /**
     * This method collects string.
     *
     * @return string
     */
    public String collect() {
        return symbol;
    }
}
