package by.korolenko.xml.bean;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 29.10.2019
 */
public enum GemEnum {
    /**
     * Gems.
     */
    GEMS("gems"),
    /**
     * Precious.
     */
    PRECIOUS("precious"),
    /**
     * Semiprecious.
     */
    SEMIPRECIOUS("semiprecious"),
    /**
     * Visual parameters.
     */
    VISUAL_PARAMETERS("visual_parameters"),
    /**
     * Color.
     */
    COLOR("color"),
    /**
     * Number.
     */
    NUMBER("number"),
    /**
     * Name.
     */
    NAME("name"),
    /**
     * Origin.
     */
    ORIGIN("origin"),
    /**
     * Transparency.
     */
    TRANSPARENCY("transparency"),
    /**
     * Cut method.
     */
    CUT_METHOD("cut_method"),
    /**
     * Faces.
     */
    FACES("faces"),
    /**
     * Production date.
     */
    PRODUCTION_DATE("production_date"),
    /**
     * Carats.
     */
    CARATS("carats"),
    /**
     * Weight.
     */
    WEIGHT("weight");

    /**
     * Value.
     */
    private String value;

    /**
     * Constructor.
     *
     * @param newValue value
     */
    GemEnum(final String newValue) {
        this.value = newValue;
    }

    /**
     * Getter for value.
     *
     * @return value
     */
    public String getValue() {
        return value;
    }
}
