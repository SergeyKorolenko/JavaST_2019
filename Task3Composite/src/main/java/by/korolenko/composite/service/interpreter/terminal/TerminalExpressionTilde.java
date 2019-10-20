package by.korolenko.composite.service.interpreter.terminal;

import by.korolenko.composite.service.interpreter.AbstractExpression;
import by.korolenko.composite.service.interpreter.Context;

public class TerminalExpressionTilde extends AbstractExpression {
    /**
     * Method.
     *
     * @param context context
     */
    @Override
    public void interpret(final Context context) {
        context.pushValue(~context.popValue());
    }
}
