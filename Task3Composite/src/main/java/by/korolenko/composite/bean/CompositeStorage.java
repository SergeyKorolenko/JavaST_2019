package by.korolenko.composite.bean;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public final class CompositeStorage {

    /**
     * Composite storage.
     */
    private static final CompositeStorage INSTANCE = new CompositeStorage();

    private CompositeStorage() {
    }

    /**
     * Composite.
     */
    private TextComposite textComposite;

    /**
     * Getter for composite.
     *
     * @return composite
     */
    public TextComposite getTextComposite() {
        return textComposite;
    }

    /**
     * Setter for composite.
     *
     * @param newTextComposite composite
     */
    public void setTextComposite(final TextComposite newTextComposite) {
        this.textComposite = newTextComposite;
    }

    /**
     * Getter for composite storage.
     *
     * @return instance
     */
    public static CompositeStorage getInstance() {
        return CompositeStorage.INSTANCE;
    }
}
