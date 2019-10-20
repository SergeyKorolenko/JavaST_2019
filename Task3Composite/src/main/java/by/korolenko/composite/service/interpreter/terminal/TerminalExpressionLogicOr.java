package by.korolenko.composite.service.interpreter.terminal;

import by.korolenko.composite.service.interpreter.AbstractExpression;
import by.korolenko.composite.service.interpreter.Context;

public class TerminalExpressionLogicOr extends AbstractExpression {
    /**
     * Interpret.
     *
     * @param context context
     */
    @Override
    public void interpret(final Context context) {
        context.pushValue(context.popValue() | context.popValue());
    }
}
