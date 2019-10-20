package by.korolenko.composite.service.interpreter.terminal;

import by.korolenko.composite.service.interpreter.AbstractExpression;
import by.korolenko.composite.service.interpreter.Context;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class TerminalExpressionShiftWithNull extends AbstractExpression {
    /**
     * Interpreting method.
     *
     * @param context context
     */
    @Override
    public void interpret(final Context context) {
        Integer number = context.popValue();
        context.pushValue(context.popValue() >>> number);
    }
}
