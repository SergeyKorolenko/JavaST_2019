package by.korolenko.composite.service.comparator;

import java.util.Comparator;

public class LexemeComparator implements Comparator<String> {

    /**
     * Compare symbol.
     */
    private char symbol;

    /**
     * Constructor.
     *
     * @param newSymbol symbol
     */
    public LexemeComparator(final char newSymbol) {
        this.symbol = newSymbol;
    }

    /**
     * Compare method.
     *
     * @param o1 string 2
     * @param o2 string 1
     * @return
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
