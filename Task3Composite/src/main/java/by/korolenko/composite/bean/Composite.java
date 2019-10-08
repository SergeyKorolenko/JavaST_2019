package by.korolenko.composite.bean;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
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
        String result = "";
        for (Component component : components) {
            result += component.collect();
        }
        return result;
    }
}
