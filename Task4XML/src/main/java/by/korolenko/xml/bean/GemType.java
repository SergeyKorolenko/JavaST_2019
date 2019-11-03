package by.korolenko.xml.bean;

import java.time.LocalDateTime;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 29.10.2019
 */
public abstract class GemType {

    /**
     * Number of a stone.
     */
    private String number;
    /**
     * Name.
     */
    private String name;
    /**
     * Origin.
     */
    private String origin;

    /**
     * Visual parameters.
     */
    private VisualParameters visualParameters = new VisualParameters();

    /**
     * Production date.
     */
    private LocalDateTime productionDate;

    /**
     * Constructor without parameters.
     */
    public GemType() {
    }

    /**
     * Constructor with parameter.
     *
     * @param newNumber           number
     * @param newName             name
     * @param newOrigin           origin
     * @param newVisualParameters visual parameters
     * @param newProductionDate   production date
     */
    public GemType(final String newNumber, final String newName,
                   final String newOrigin,
                   final VisualParameters newVisualParameters,
                   final LocalDateTime newProductionDate) {
        this.number = newNumber;
        this.name = newName;
        this.origin = newOrigin;
        this.visualParameters = newVisualParameters;
        this.productionDate = newProductionDate;
    }

    /**
     * Getter for number.
     *
     * @return number
     */
    public String getNumber() {
        return number;
    }

    /**
     * Setter for number.
     *
     * @param newNumber number
     */
    public void setNumber(final String newNumber) {
        this.number = newNumber;
    }

    /**
     * Getter for name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name.
     *
     * @param newName name
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * Getter for origin.
     *
     * @return origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Setter for origin.
     *
     * @param newOrigin origin
     */
    public void setOrigin(final String newOrigin) {
        this.origin = newOrigin;
    }

    /**
     * Getter for visual parameters.
     *
     * @return visual parameters
     */
    public VisualParameters getVisualParameters() {
        return visualParameters;
    }

    /**
     * Setter for visual parameters.
     *
     * @param newVisualParameters visual parameters
     */
    public void setVisualParameters(
            final VisualParameters newVisualParameters) {
        this.visualParameters = newVisualParameters;
    }

    /**
     * Getter for date.
     *
     * @return date
     */
    public LocalDateTime getProductionDate() {
        return productionDate;
    }

    /**
     * Setter for date.
     *
     * @param newProductionDate production date
     */
    public void setProductionDate(final LocalDateTime newProductionDate) {
        this.productionDate = newProductionDate;
    }

    /**
     * To string.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "GemType{"
                + "number='" + number + '\''
                + ", name='" + name + '\''
                + ", origin='" + origin + '\''
                + ", visualParameters=" + visualParameters
                + ", productionDate=" + productionDate
                + '}';
    }
}
