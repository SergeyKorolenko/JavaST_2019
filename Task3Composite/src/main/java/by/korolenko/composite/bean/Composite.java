package by.korolenko.composite.bean;

import by.korolenko.composite.bean.enums.TextPart;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    /**
     * list of components.
     */
    private List<Component> components = new ArrayList<>();
    /**
     * Text type.
     */
    private TextPart type;

    /**
     * Constructor.
     *
     * @param newType type
     */
    public Composite(final TextPart newType) {
        this.type = newType;
    }

    /**
     * Add method.
     *
     * @param component component
     */
    @Override
    public void add(final Component component) {
        components.add(component);
    }

    /**
     * Get method.
     *
     * @param index index
     * @return component
     */
    @Override
    public Component getChild(final int index) {
        return components.get(index);
    }

    /**
     * Remove method.
     *
     * @param component component
     */
    @Override
    public void remove(final Component component) {
        components.remove(component);
    }
    /**
     * This method collects string.
     *
     * @return string
     */
    public String collect() {
        StringBuilder result = new StringBuilder();
        for (Component component : components) {
            switch (type) {
                case TEXT:
                    result.append("    ").append(component.collect().trim()).
                            append("\n");
                    break;
                case SENTENCE:
                    result.append(component.collect()).append(" ");
                    break;
                case PARAGRAPH:
                case WORD:
                case LEXEME:
                    result.append(component.collect());
                    break;
                default:
                    break;
            }
        }
        return result.toString();
    }

    /**
     * Getter for components.
     *
     * @return components.
     */
    public List<Component> getComponents() {
        return components;
    }

    /**
     * Calculates size.
     *
     * @return list size
     */
    public int getNumberChild() {
        return components.size();
    }

}
