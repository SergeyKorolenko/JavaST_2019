package by.korolenko.mobile.bean;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public class BusinessTariff extends Tariff {

    /**
     * The number of minutes of free roaming.
     */
    private int roaming;

    /**
     * This is the constructor with parameters.
     *
     * @param name       tariff name
     * @param price      tariff rate
     * @param freeMinute number of free minutes
     * @param traffic    number of free traffic
     * @param newRoaming number of roaming minutes
     */
    public BusinessTariff(final String name, final double price,
                          final int freeMinute, final int traffic,
                          final int newRoaming) {
        super(name, price, freeMinute, traffic);
        this.roaming = newRoaming;
    }

    /**
     * Getter for roaming.
     *
     * @return roaming
     */
    public int getRoaming() {
        return roaming;
    }

    /**
     * Setter for roaming.
     *
     * @param newRoaming roaming
     */
    public void setRoaming(final int newRoaming) {
        this.roaming = newRoaming;
    }

    /**
     * This is the override toString method.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "BUSINESS,"
                + super.toString()
                + ',' + roaming;
    }

    /**
     * This is the override hashCode method.
     *
     * @return int number
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + roaming;
        return result;
    }

    /**
     * This is the override equals method.
     *
     * @param obj the object to be compared
     * @return comparison result
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        BusinessTariff other = (BusinessTariff) obj;
        return roaming == other.roaming;
    }
}
