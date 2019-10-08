package by.korolenko.composite.bean;

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
    private Composite composite;

    /**
     * Getter for composite.
     *
     * @return composite
     */
    public Composite getComposite() {
        return composite;
    }

    /**
     * Setter for composite.
     *
     * @param newComposite composite
     */
    public void setComposite(final Composite newComposite) {
        this.composite = newComposite;
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
