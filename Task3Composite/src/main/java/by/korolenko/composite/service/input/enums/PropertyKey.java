package by.korolenko.composite.service.input.enums;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public enum PropertyKey {
    /**
     * There are keys.
     */
    TEXT("text"), OUTPUT("output");
    /**
     * Key name.
     */
    private String keyName;

    /**
     * This is the constructor.
     *
     * @param newKeyName key name
     */
    PropertyKey(final String newKeyName) {
        this.keyName = newKeyName;
    }

    /**
     * Getter for key name.
     *
     * @return name
     */
    public String getKeyName() {
        return keyName;
    }
}
