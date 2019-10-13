package by.korolenko.composite.bean;

import java.util.Objects;

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

    /**
     * Equals method.
     *
     * @param o object
     * @return result
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Symbol symbol1 = (Symbol) o;
        return symbol == symbol1.symbol;
    }

    /**
     * Hash code method.
     *
     * @return int number
     */
    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }

    /**
     * To string method.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "Symbol{"
                + "symbol=" + symbol
                + '}';
    }
}
