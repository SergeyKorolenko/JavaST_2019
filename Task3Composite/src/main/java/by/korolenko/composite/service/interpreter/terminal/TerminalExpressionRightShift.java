package by.korolenko.composite.service.interpreter.terminal;

import by.korolenko.composite.service.interpreter.AbstractExpression;
import by.korolenko.composite.service.interpreter.Context;

public class TerminalExpressionRightShift extends AbstractExpression {
    /**
     * Method.
     *
     * @param context context
     */
    @Override
    public void interpret(final Context context) {
        int n1 = context.popValue();
        context.pushValue(context.popValue() >> n1);
    }
}
