package by.korolenko.composite.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class TextComposite implements Component {
    /**
     * list of components.
     */
    private List<Component> components = new ArrayList<>();

    /**
     * Add method.
     *
     * @param component component
     */
    public void add(final Component component) {
        components.add(component);
    }

    /**
     * This method collects string.
     *
     * @return string
     */
    public String collect() {
        StringBuilder result = new StringBuilder();
        for (Component component : components) {
            result.append(component.collect());
        }
        return result.toString();
    }
}
