package by.korolenko.xml.bean;

import java.time.LocalDateTime;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 29.10.2019
 */
public class Semiprecious extends GemType {

    /**
     * Weight of a stone.
     */
    private double weight;

    /**
     * Constructor.
     */
    public Semiprecious() {
    }

    /**
     * Constructor.
     *
     * @param newNumber           number
     * @param newName             name
     * @param newOrigin           origin
     * @param newVisualParameters visual parameters
     * @param newProductionDate   production date
     * @param newWeight           weight
     */
    public Semiprecious(final String newNumber, final String newName,
                        final String newOrigin,
                        final VisualParameters newVisualParameters,
                        final LocalDateTime newProductionDate,
                        final double newWeight) {
        super(newNumber, newName, newOrigin, newVisualParameters,
                newProductionDate);
        this.weight = newWeight;
    }

    /**
     * Getter for weight.
     *
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Setter for weight.
     *
     * @param newWeight weight
     */
    public void setWeight(final double newWeight) {
        this.weight = newWeight;
    }

    /**
     * To string.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "Semiprecious{"
                + "weight=" + weight
                + "} " + super.toString();
    }
}
