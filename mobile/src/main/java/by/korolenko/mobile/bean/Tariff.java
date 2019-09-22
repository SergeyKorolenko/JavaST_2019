package by.korolenko.mobile.bean;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public abstract class Tariff {

    /**
     * This field generates id.
     */
    private static int count = 0;

    /**
     * This is id.
     */
    private int id;

    /**
     * This is the name of tariff.
     */
    private String name;

    /**
     * This is the tariff rate.
     */
    private double price;

    /**
     * This is the number of free minutes.
     */
    private int freeMinute;

    /**
     * This is the number of free traffic.
     */
    private int traffic;

    /**
     * This is the constructor with parameters.
     *
     * @param newName       tariff name
     * @param newPrice      tariff rate
     * @param newFreeMinute number of free minutes
     * @param newTraffic    number of free traffic
     */
    public Tariff(final String newName, final double newPrice,
                  final int newFreeMinute, final int newTraffic) {
        this.id = ++count;
        this.name = newName;
        this.price = newPrice;
        this.freeMinute = newFreeMinute;
        this.traffic = newTraffic;
    }

    /**
     * Getter for id.
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter fo id.
     *
     * @param newId id
     */
    public void setId(final int newId) {
        this.id = newId;
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
     * @param newName tariff name
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * Getter for price.
     *
     * @return tariff rate
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter fo price.
     *
     * @param newPrice tariff rate
     */
    public void setPrice(final double newPrice) {
        this.price = newPrice;
    }

    /**
     * Getter for free minutes.
     *
     * @return free minutes.
     */
    public int getFreeMinute() {
        return freeMinute;
    }

    /**
     * Setter for free minutes.
     *
     * @param newFreeMinute the number of free minutes
     */
    public void setFreeMinute(final int newFreeMinute) {
        this.freeMinute = newFreeMinute;
    }

    /**
     * Getter for traffic.
     *
     * @return traffic
     */
    public int getTraffic() {
        return traffic;
    }

    /**
     * Setter for traffic.
     *
     * @param newTraffic traffic
     */
    public void setTraffic(final int newTraffic) {
        this.traffic = newTraffic;
    }

    /**
     * This is the override toString method.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "" + name + ','
                + price + ','
                + freeMinute + ','
                + traffic;
    }

    /**
     * This is the override hashCode method.
     *
     * @return int number
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + freeMinute;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        long temp;
        temp = Double.doubleToLongBits(price);
        final int shift = 32;
        result = prime * result + (int) (temp ^ (temp >>> shift));
        result = prime * result + traffic;
        return result;
    }

    /**
     * This is the override equals methos.
     *
     * @param obj the object to be compared
     * @return comparison result
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Tariff other = (Tariff) obj;
        if (freeMinute != other.freeMinute) {
            return false;
        }
        if (id != other.id) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (Double.doubleToLongBits(price)
                != Double.doubleToLongBits(other.price)) {
            return false;
        }
        return traffic == other.traffic;
    }
}
