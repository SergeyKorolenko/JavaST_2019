package by.korolenko.composite.service.comparator;

import java.util.Comparator;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class LexemeComparator implements Comparator<String> {

    /**
     * Compared symbol.
     */
    private char symbol;

    /**
     * Constructor with parameter.
     *
     * @param newSymbol symbol
     */
    public LexemeComparator(final char newSymbol) {
        this.symbol = newSymbol;
    }

    /**
     * Compare method.
     *
     * @param o1 first string
     * @param o2 second string
     * @return result
     */
    @Override
    public int compare(final String o1, final String o2) {
        char[] str1 = o1.toCharArray();
        char[] str2 = o2.toCharArray();
        int count1 = 0;
        int count2 = 0;
        for (char c : str1) {
            if (c == symbol) {
                count1++;
            }
        }
        for (char c : str2) {
            if (c == symbol) {
                count2++;
            }
        }
        return count1 - count2;
    }
}
