package by.korolenko.xml.bean;

import java.time.LocalDateTime;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 29.10.2019
 */
public class Precious extends GemType {

    /**
     * Number of carats.
     */
    private double carats;

    /**
     * Constructor.
     */
    public Precious() {
    }

    /**
     * Constructor.
     *
     * @param newNumber           number
     * @param newName             name
     * @param newOrigin           origin
     * @param newVisualParameters visual parameters
     * @param newProductionDate   production date
     * @param newCarats           carats
     */
    public Precious(final String newNumber, final String newName,
                    final String newOrigin,
                    final VisualParameters newVisualParameters,
                    final LocalDateTime newProductionDate,
                    final double newCarats) {
        super(newNumber, newName, newOrigin, newVisualParameters,
                newProductionDate);
        this.carats = newCarats;
    }

    /**
     * Getter for carats.
     *
     * @return carats
     */
    public double getCarats() {
        return carats;
    }

    /**
     * Setter for carats.
     *
     * @param newCarats carats
     */
    public void setCarats(final double newCarats) {
        this.carats = newCarats;
    }

    /**
     * To string.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "Precious{"
                + "carats=" + carats
                + "} " + super.toString();
    }
}
