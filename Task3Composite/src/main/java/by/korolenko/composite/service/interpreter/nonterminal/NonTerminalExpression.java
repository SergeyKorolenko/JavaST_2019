package by.korolenko.composite.service.interpreter.nonterminal;

import by.korolenko.composite.service.interpreter.AbstractExpression;
import by.korolenko.composite.service.interpreter.Context;

public class NonTerminalExpression extends AbstractExpression {

    /**
     * Number.
     */
    private int number;

    /**
     * Constructor.
     *
     * @param newNumber number
     */
    public NonTerminalExpression(final int newNumber) {
        this.number = newNumber;
    }

    /**
     * Interpret.
     *
     * @param context context
     */
    @Override
    public void interpret(final Context context) {
        context.pushValue(number);
    }
}
