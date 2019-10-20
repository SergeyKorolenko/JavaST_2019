package by.korolenko.composite.service.interpreter;

import java.util.ArrayDeque;
import java.util.Deque;

public class Context {

    /**
     * Deque for numbers.
     */
    private Deque<Integer> contextValues = new ArrayDeque<>();

    /**
     * Pop value from the deque.
     *
     * @return value
     */
    public Integer popValue() {
        return contextValues.pop();
    }

    /**
     * Push value to the deque.
     *
     * @param value value
     */
    public void pushValue(final Integer value) {
        contextValues.push(value);
    }
}
