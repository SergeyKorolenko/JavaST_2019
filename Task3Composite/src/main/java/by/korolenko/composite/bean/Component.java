package by.korolenko.composite.bean;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public interface Component {
    /**
     * This method collects text to the string.
     *
     * @return text as a string
     */
    String collect();

    /**
     * This method removes a component.
     *
     * @param component component to be removed
     */
    default void remove(Component component) {
    }

    /**
     * This method gets component from the index.
     *
     * @param index index
     * @return component
     */
    default Component getChild(int index) {
        throw new UnsupportedOperationException();
    }

    /**
     * This method adds a component.
     *
     * @param component component
     */
    default void add(Component component) {
    }
}
