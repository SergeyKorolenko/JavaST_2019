package by.korolenko.composite.repository.collector;

import by.korolenko.composite.bean.Component;
import by.korolenko.composite.bean.Composite;
import by.korolenko.composite.bean.enums.TextPart;

import java.util.ArrayList;
import java.util.List;

public class ComponentCollector {

    /**
     * This method collects components by text part.
     *
     * @param composite composite
     * @param textPart  text part
     * @return list of components
     */
    public List<Component> collectComponent(final Composite composite,
                                            final TextPart textPart) {
        List<Component> componentList = new ArrayList<>();
        if (composite.getType() == textPart) {
            componentList.addAll(composite.getComponents());
            return componentList;
        }
        for (Component component : composite.getComponents()) {
            if (((Composite) component).getType() == textPart) {
                componentList.addAll(((Composite) component).getComponents());
            } else {
                componentList.addAll(collectComponent((Composite) component,
                        textPart));
            }
        }
        return componentList;
    }
}
