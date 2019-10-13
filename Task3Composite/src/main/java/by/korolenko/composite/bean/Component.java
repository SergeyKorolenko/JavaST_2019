package by.korolenko.composite.bean;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public interface Component {
    /**
     * This method collects string.
     *
     * @return string
     */
    String collect();

    /**
     * Remove method.
     *
     * @param component component
     */
    default void remove(Component component) {
    }

    /**
     * Get child method.
     *
     * @param i index
     * @return component
     */
    default Component getChild(int i) {
        throw new UnsupportedOperationException();
    }

    /**
     * Add method.
     *
     * @param component component
     */
    default void add(Component component) {
    }
}
