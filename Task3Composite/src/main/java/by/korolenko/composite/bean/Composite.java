package by.korolenko.composite.bean;

import by.korolenko.composite.bean.enums.TextPart;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class Composite implements Component {
    /**
     * list of components.
     */
    private List<Component> components = new ArrayList<>();
    /**
     * Text part.
     */
    private TextPart part;

    /**
     * Constructor with parameter.
     *
     * @param newPart type
     */
    public Composite(final TextPart newPart) {
        this.part = newPart;
    }

    /**
     * This method adds a component.
     *
     * @param component component
     */
    @Override
    public void add(final Component component) {
        components.add(component);
    }

    /**
     * This method gets component from the index.
     *
     * @param index index
     * @return component
     */
    @Override
    public Component getChild(final int index) {
        return components.get(index);
    }

    /**
     * This method removes a component.
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
            switch (part) {
                case PARAGRAPH:
                    result.append("\t").append(component.collect().trim()).
                            append("\r\n");
                    break;
                case LEXEME:
                    result.append(component.collect()).append(" ");
                    break;
                case WORD:
                case SENTENCE:
                case SYMBOL:
                    result.append(component.collect());
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        return result.toString();
    }

    /**
     * Getter for the list of components.
     *
     * @return the ist of components.
     */
    public List<Component> getComponents() {
        return components;
    }

    /**
     * This method returns size of the list of components.
     *
     * @return size of the list of components
     */
    public int size() {
        return components.size();
    }

    /**
     * Getter for the text part.
     *
     * @return type
     */
    public TextPart getType() {
        return part;
    }

    /**
     * Setter for the text part.
     *
     * @param newPart text part
     */
    public void setType(final TextPart newPart) {
        this.part = newPart;
    }
}
