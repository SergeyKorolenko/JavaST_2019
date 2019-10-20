package by.korolenko.composite.service.interpreter;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class Context {

    /**
     * Deque for numbers.
     */
    private Deque<Integer> contextValues = new ArrayDeque<>();

    /**
     * This method pops a value from the deque.
     *
     * @return value
     */
    public Integer popValue() {
        return contextValues.pop();
    }

    /**
     * This method pushes a value to the deque.
     *
     * @param value value
     */
    public void pushValue(final Integer value) {
        contextValues.push(value);
    }
}
