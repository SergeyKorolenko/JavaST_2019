package by.korolenko.composite.service.interpreter;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public abstract class AbstractExpression {
    /**
     * Interpreting method.
     *
     * @param context context
     */
    public abstract void interpret(Context context);
}
