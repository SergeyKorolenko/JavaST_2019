package by.korolenko.composite.service.interpreter.nonterminal;

import by.korolenko.composite.service.interpreter.AbstractExpression;
import by.korolenko.composite.service.interpreter.Context;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class NonTerminalExpression extends AbstractExpression {

    /**
     * Number.
     */
    private int number;

    /**
     * Constructor with parameter.
     *
     * @param newNumber number
     */
    public NonTerminalExpression(final int newNumber) {
        this.number = newNumber;
    }

    /**
     * Interpreting method.
     *
     * @param context context
     */
    @Override
    public void interpret(final Context context) {
        context.pushValue(number);
    }
}
